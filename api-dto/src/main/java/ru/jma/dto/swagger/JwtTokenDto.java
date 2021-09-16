package ru.jma.dto.swagger;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtTokenDto {

    @JsonProperty("access_token")
    private String accessToken;
}
