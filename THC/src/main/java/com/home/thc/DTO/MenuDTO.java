package com.home.thc.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuDTO implements Serializable {

    private long id;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "price")
    private double price;
    @JsonProperty(value = "ingredients")
    private String ingredients;
}
