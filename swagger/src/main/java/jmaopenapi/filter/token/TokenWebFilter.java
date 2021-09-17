package jmaopenapi.filter.token;

import jmaopenapi.controller.AbstractSecuredController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TokenWebFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        List<String> authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.get(0) != null) {
            // todo: get rid of this stateful bullshit
            AbstractSecuredController.setBearerToken(authHeader.get(0).substring(7));
        }
        return chain.filter(exchange);
    }
}
