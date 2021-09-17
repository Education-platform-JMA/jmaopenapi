package jmaopenapi.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Setter;

@SecurityRequirement(name = "keycloak")
public abstract class AbstractSecuredController {

    @Setter
    protected static String bearerToken;
}
