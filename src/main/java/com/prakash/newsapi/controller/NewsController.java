package com.prakash.newsapi.controller;

import com.prakash.newsapi.model.response.ArticlesResponse;
import com.prakash.newsapi.model.response.SourceResponse;
import com.prakash.newsapi.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/everything")
    public ArticlesResponse getNews(
            @RequestParam(required = false) String q,
            @RequestParam(required = false) String sources,
            @RequestParam(required = false) String domains,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) Integer page) {

        return newsService.fetchNews(q,
                sources,
                domains,
                from,
                to,
                language,
                sortBy,
                pageSize,
                page);
    }

    @GetMapping("/top-headlines")
    public ArticlesResponse getTopHeadlines(
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String sources,
            @RequestParam(required = false) String q,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) Integer page) {

        return newsService.fetchTopHeadlines(country,
                category,
                sources,
                q,
                pageSize,
                page);
    }

    @GetMapping("/sources")
    public SourceResponse getSources(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String country) {
        return newsService.fetchSources(category,
                language,
                country);
    }
}
