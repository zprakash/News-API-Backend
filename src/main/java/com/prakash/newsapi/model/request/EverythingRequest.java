package com.prakash.newsapi.model.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.util.UriComponentsBuilder;

@Data
@Builder
public class EverythingRequest {
    private String q;
    private String sources;
    private String domains;
    private String from;
    private String to;
    private String language;
    private String sortBy;
    private Integer pageSize;
    private Integer page;

    public String buildUrl(String baseUrl) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl);

        addQueryParamIfNotNull(builder, "q", q);
        addQueryParamIfNotNull(builder, "sources", sources);
        addQueryParamIfNotNull(builder, "domains", domains);
        addQueryParamIfNotNull(builder, "from", from);
        addQueryParamIfNotNull(builder, "to", to);
        addQueryParamIfNotNull(builder, "language", language);
        addQueryParamIfNotNull(builder, "sortBy", sortBy);
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
