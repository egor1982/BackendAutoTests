package org.example.lesson4;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "original",
        "metric",
        "us"
})
@Data
public class Measures {
    @JsonProperty("original")
    public MeasuresType original;
    @JsonProperty("metric")
    public MeasuresType metric;
    @JsonProperty("us")
    public MeasuresType us;
}
