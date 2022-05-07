package com.adrianpoplesanu.MatchDay2.utils.footbal_data_api;

import com.adrianpoplesanu.MatchDay2.utils.footbal_data_api.model.ApiResponse;
import com.adrianpoplesanu.MatchDay2.utils.footbal_data_api.model.Match;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class FootballDataApiClient {
    private static final int size = 16 * 1024 * 1024;

    @Value("${football.api.token}")
    private String footballAPIToken;
    public Match[] getMatchesForCompetition(String competition) {
        System.out.println(footballAPIToken);
        WebClient webClient2 = WebClient.builder()
                .exchangeStrategies(getMaxDownloadLimit())
                .baseUrl("https://api.football-data.org")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("X-Auth-Token", footballAPIToken)
                .build();

        Mono<ApiResponse> monoResult = webClient2.get()
                .uri("/v2/competitions/"+ competition + "/matches")
                .retrieve()
                .bodyToMono(ApiResponse.class);

        ApiResponse response = monoResult.block();
        System.out.println(response);
        return null;
    }

    private ExchangeStrategies getMaxDownloadLimit() {
        ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();
        return strategies;
    }
}
