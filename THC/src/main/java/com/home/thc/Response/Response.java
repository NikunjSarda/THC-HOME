package com.home.thc.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@RequiredArgsConstructor(staticName = "from")
public class Response<T> {

    @JsonProperty("meta")
    @NonNull ResponseMetaData meta;

    @JsonProperty("data")
    @JsonInclude(NON_NULL)
    T data;

    public Response(ResponseMetaData meta , T data){
        this.meta = meta;
        this.data = data;
    }
}