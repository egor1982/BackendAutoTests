package org.example.lesson4;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "amount",
        "unit"
})
@Data
public class Nutrient {
    @JsonProperty("name")
    public String name;
    @JsonProperty("amount")
    public Double amount;
    @JsonProperty("unit")
    public String unit;
}
