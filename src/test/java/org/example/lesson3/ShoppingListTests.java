package org.example.lesson3;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ShoppingListTests {
    private static final String APIKEY = "a42be208cf524e628743385d257877cf";
    private static String id;
    private static String user;
    private static String pass;
    private static String hash;
    @BeforeAll
    public static void login(){
        Response response =given()
                .queryParam("apiKey", APIKEY)
                .body("{ \"username\": \"egor1982\" }")
                .when()
                .post("https://api.spoonacular.com/users/connect");
        JsonPath json = response
                .body()
                .jsonPath();
        response
                .then()
                .statusCode(200);
        assertThat(json.getString("status"), equalTo("success" ));
        user = json.getString("username");
        pass = json.getString("spoonacularPassword");
        hash = json.getString("hash");
    }
    @Test
    void addShoppingListTest() {
        id = given()
                .queryParam("hash", ShoppingListTests.hash)
                .queryParam("username", ShoppingListTests.user)
                .queryParam("apiKey", APIKEY)
                .body("{\n"
                        + " \"item\": \"salami\",\n"
                        + " \"aisle\": \"Sausages\",\n"
                        + " \"parse\": 0,\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/"+ShoppingListTests.user+"/shopping-list/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();
    }
    @Test
    void getShoppingListTest() {
        given()
                .queryParam("hash", ShoppingListTests.hash)
                .queryParam("username", ShoppingListTests.user)
                .queryParam("apiKey", APIKEY)
                .expect()
                .body("aisles[0].items[0].name",equalTo("salami"))
                .when()
                .get("https://api.spoonacular.com/mealplanner/"+ShoppingListTests.user+"/shopping-list")
                .then()
                .statusCode(200);
    }
    @AfterAll
    public static void tearDown() {
        given()
                .queryParam("hash", ShoppingListTests.hash)
                .queryParam("username", ShoppingListTests.user)
                .queryParam("apiKey", APIKEY)
                .delete("https://api.spoonacular.com/mealplanner/"+ShoppingListTests.user+"/shopping-list/items/" + id)
                .then()
                .statusCode(200);
    }
}
