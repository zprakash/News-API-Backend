package com.prakash.newsapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prakash.newsapi.configuration.NewsClient;
import com.prakash.newsapi.configuration.BaseUrls;
import com.prakash.newsapi.model.request.EverythingRequest;
import com.prakash.newsapi.model.request.SourcesRequest;
import com.prakash.newsapi.model.request.TopHeadlinesRequest;
import com.prakash.newsapi.model.response.ArticlesResponse;
import com.prakash.newsapi.model.response.SourceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsService {

	private final ObjectMapper objectMapper;
	private final NewsClient newsClient;

	public ArticlesResponse fetchNews(
					String q, String sources, String domains,
					String from, String to, String language,
					String sortBy, Integer pageSize, Integer page) {
		
		EverythingRequest request = EverythingRequest.builder()
						.q(q)
						.sources(sources)
						.domains(domains)
						.from(from)
						.to(to)
						.language(language)
						.sortBy(sortBy)
						.pageSize(pageSize)
						.page(page)
						.build();
		
		String url = request.buildUrl(BaseUrls.BASE_URL_FOR_EVERYTHING);
		return callAndMapIntoArticle(url);
	}
	
	public ArticlesResponse fetchTopHeadlines(
					String country, String category, String sources,
					String q, Integer pageSize, Integer page) {
		
		TopHeadlinesRequest topheadlinesRequest = TopHeadlinesRequest.builder()
						.country(country)
						.category(category)
						.sources(sources)
						.q(q)
						.pageSize(pageSize)
						.page(page)
						.build();
		
		String url = topheadlinesRequest.buildUrl(BaseUrls.BASE_URL_FOR_TOPHEADLINES);
		return callAndMapIntoArticle(url);
	}
	
	public SourceResponse fetchSources(String category, String language, String country) {
		
		SourcesRequest sourcesRequest = SourcesRequest.builder()
						.category(category)
						.language(language)
						.country(country)
						.build();
		
		String url = sourcesRequest.buildUrl(BaseUrls.BASE_URL_FOR_SOURCES);
		var response = newsClient.getNews(url);
		try {
			return objectMapper.readValue(response.getBody(), SourceResponse.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private ArticlesResponse callAndMapIntoArticle(String url) {
		var response = newsClient.getNews(url);
		try {
			return objectMapper.readValue(response.getBody(), ArticlesResponse.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
