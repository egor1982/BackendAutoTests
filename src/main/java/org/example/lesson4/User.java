package org.example.lesson4;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "username",
        "spoonacularPassword",
        "hash"
})
@Data
public class User {
    @JsonProperty("status")
    public String status;
    @JsonProperty("username")
    public String username;
    @JsonProperty("spoonacularPassword")
    public String spoonacularPassword;
    @JsonProperty("hash")
    public String hash;
}
