package com.prakash.newsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.http.HttpClient;

@SpringBootApplication
public class NewsapiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NewsapiApplication.class, args);
	}
	
	@Bean
	public HttpClient httpClient(){
        return HttpClient.newBuilder().build();
	}
}
