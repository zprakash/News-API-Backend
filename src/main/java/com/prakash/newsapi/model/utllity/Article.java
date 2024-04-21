package com.prakash.newsapi.model.utllity;

import com.prakash.newsapi.dto.SourceDto;
import lombok.Data;

@Data
public class Article {
	private SourceDto source;
	private String author;
	private String title;
	private String description;
	private String url;
	private String urlToImage;
	private String publishedAt;
	private String content;
}
