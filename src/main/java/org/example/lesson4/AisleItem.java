package org.example.lesson4;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "measures",
        "pantryItem",
        "aisle",
        "cost",
        "ingredientId",
        "usages",
        "usageRecipeIds"
})
@Data
public class AisleItem {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("measures")
    public Measures measures;
    @JsonProperty("pantryItem")
    public Boolean pantryItem;
    @JsonProperty("aisle")
    public String aisle;
    @JsonProperty("cost")
    public Double cost;
    @JsonProperty("ingredientId")
    public Integer ingredientId;
    @JsonProperty("usages")
    public List<String> usages = new ArrayList<String>();
    @JsonProperty("usageRecipeIds")
    public List<String> usageRecipeIds = new ArrayList<String>();
}
