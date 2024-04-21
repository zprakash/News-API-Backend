package com.prakash.newsapi.model.response;

import com.prakash.newsapi.model.utllity.Article;
import lombok.Data;

import java.util.List;

@Data
public class ArticlesResponse{
	private String status;
	private Integer totalResults;
	private List<Article> articles;
}
