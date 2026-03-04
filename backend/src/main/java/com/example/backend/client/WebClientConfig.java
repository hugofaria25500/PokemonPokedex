package com.example.backend.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    ExchangeStrategies strategies = ExchangeStrategies.builder()
            .codecs(config ->
                    config.defaultCodecs().maxInMemorySize(2 * 1024 * 1024)
            )
            .build();

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://pokeapi.co/api/v2")
                .exchangeStrategies(strategies)
                .build();
    }
}
