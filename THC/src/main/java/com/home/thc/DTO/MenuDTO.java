package com.home.thc.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuDTO {

    private long id;
    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "item")
    private String item;
    @JsonProperty(value = "price")
    private double price;
}
