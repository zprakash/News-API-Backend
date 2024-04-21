package com.prakash.newsapi.model.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.util.UriComponentsBuilder;

@Data
@Builder
public class TopHeadlinesRequest {
    private String country;
    private String category;
    private String sources;
    private String q;
    private Integer pageSize;
    private Integer page;

    public String buildUrl(String baseUrl) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl);

        addQueryParamIfNotNull(builder, "country", country);
        addQueryParamIfNotNull(builder, "category", category);
        addQueryParamIfNotNull(builder, "sources", sources);
        addQueryParamIfNotNull(builder, "q", q);
        addQueryParamIfNotNull(builder, "pageSize", pageSize);
        addQueryParamIfNotNull(builder, "page", page);

        return builder.build(true).toUriString();
    }

    private void addQueryParamIfNotNull(UriComponentsBuilder builder, String paramName, Object paramValue) {
        if (paramValue != null) {
            builder.queryParam(paramName, paramValue);
        }
    }
}
