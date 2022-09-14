package org.example.lesson4;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "amount",
        "unit"
})
@Data
public class MeasuresType {
    @JsonProperty("amount")
    public Double amount;
    @JsonProperty("unit")
    public String unit;
}
