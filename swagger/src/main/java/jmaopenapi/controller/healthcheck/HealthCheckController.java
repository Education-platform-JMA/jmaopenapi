package jmaopenapi.controller.healthcheck;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jmaopenapi.config.WebClientConfig;
import jmaopenapi.controller.AbstractSecuredController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController("health")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class HealthCheckController extends AbstractSecuredController {
    private final WebClient webClient;
    @Value("${uri.gateway}")
    private final String gatewayUri;

    @GetMapping("actuator")
    public Mono<String> getHealth(@RequestParam(required = false) String serviceName) {
        String fullServiceName = serviceName == null ? "" : "/" + serviceName;
        return webClient.get()
                .uri(gatewayUri + fullServiceName + "/actuator")
                .headers(h -> h.setBearerAuth(bearerToken))
                .retrieve()
                .bodyToMono(String.class);
    }
}
