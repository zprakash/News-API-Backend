package com.prakash.newsapi.model.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.util.UriComponentsBuilder;

@Data
@Builder
public class SourcesRequest {
    private String category;
    private String language;
    private String country;

    public String buildUrl(String baseUrlForSources) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrlForSources);

        addQueryParamIfNotNull(builder, "category", category);
        addQueryParamIfNotNull(builder, "language", language);
        addQueryParamIfNotNull(builder, "country", country);

        return builder.build(true).toUriString();
    }

    private void addQueryParamIfNotNull(UriComponentsBuilder builder, String paramName, Object paramValue) {
        if (paramValue != null) {
            builder.queryParam(paramName, paramValue);
        }
    }
}
