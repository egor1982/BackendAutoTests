package org.example.lesson4;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "aisle",
        "items"
})
@Data
public class Aisle {
    @JsonProperty("aisle")
    public String aisle;
    @JsonProperty("items")
    public List<AisleItem> items = new ArrayList<AisleItem>();
}
