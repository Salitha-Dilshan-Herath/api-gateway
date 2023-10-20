package com.sample.apigateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.LogManager;
import java.util.logging.Logger;


class GetRequestFilter implements GatewayFilter {

    private static final Logger LOGGER = Logger.getLogger(GetRequestFilter.class.getName());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // GET request filter logic
        // You can access the request body using exchange.getRequest().getBody()
        // You can access request headers and modify the request as needed

        LOGGER.info("GetRequestFilter Path ===> " + exchange.getRequest().getPath());
        LOGGER.info("GetRequestFilter Header ===> " + exchange.getRequest().getHeaders());

        return chain.filter(exchange);
    }
}

class PostRequestFilter implements GatewayFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // POST request filter logic
        // You can access and modify the request body and headers
        return chain.filter(exchange);
    }
}

class PutRequestFilter implements GatewayFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // PUT request filter logic
        // You can access and modify the request body and headers
        return chain.filter(exchange);
    }
}

class DeleteRequestFilter implements GatewayFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // DELETE request filter logic
        // You can access and modify the request headers
        return chain.filter(exchange);
    }
}
