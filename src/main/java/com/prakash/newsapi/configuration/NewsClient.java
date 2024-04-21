package com.prakash.newsapi.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Component
@RequiredArgsConstructor
public class NewsClient {
    private final HttpClient httpClient;
    @Value("${news.api.apiKey}")
    private String apiKey;

    public ResponseEntity<String> getNews(String uri) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .header("X-Api-Key", apiKey).build();
        try {
            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            return new ResponseEntity<>(body,
                    HttpStatus.OK);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
