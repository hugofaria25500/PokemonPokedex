package com.example.backend.client;

import com.example.backend.service.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class WebClientConfig {

    private static final Logger logger = LoggerFactory.getLogger(WebClientConfig.class);

    ExchangeStrategies strategies = ExchangeStrategies.builder()
            .codecs(config ->
                    config.defaultCodecs().maxInMemorySize(2 * 1024 * 1024)
            )
            .build();

    @Bean
    public WebClient webClient() {
        try {
            return WebClient.builder()
                    .baseUrl("https://pokeapi.co/api/v2")
                    .exchangeStrategies(strategies)
                    .clientConnector(new ReactorClientHttpConnector(
                            HttpClient.create()
                                    .responseTimeout(Duration.ofSeconds(5))
                    ))
                    .build();
        } catch (WebClientException e) {
            logger.error("Erro ao criar WebClient", e);
            throw e;
        }
    }
}
