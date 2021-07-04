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
public class CustomerDTO implements Serializable {

    private long id;
    @JsonProperty(value = "customerName")
    private String customerName;
    @JsonProperty(value = "emailId")
    private String emailId;
    @JsonProperty(value = "phone")
    private String phone;
}