package com.niladri.api_gateway.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoggingSpecificFilter extends AbstractGatewayFilterFactory<LoggingSpecificFilter.Config> {

    private static final Logger log = LoggerFactory.getLogger(LoggingSpecificFilter.class);

    public LoggingSpecificFilter() {
        super(Config.class);
    }


    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
         log.info("Logging from specific pre: {}", exchange.getRequest().getURI());
            return chain.filter(exchange);
        });
    }
    public static class Config {
    }
}
