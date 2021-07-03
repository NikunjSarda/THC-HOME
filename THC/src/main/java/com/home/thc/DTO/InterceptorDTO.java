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
public class InterceptorDTO implements Serializable {

    private long id;
    @JsonProperty(value = "executionTime")
    private long executionTime;
    @JsonProperty(value = "url")
    private String url;
    @JsonProperty(value = "urlDate")
    private String urlDate;
}
