package com.xaltius.be.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xaltius.be.model.PersonColor;
import com.xaltius.be.model.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PersonColorResponse extends BaseResponse {
    @JsonProperty("data")
    private PersonColor personColor;
}
