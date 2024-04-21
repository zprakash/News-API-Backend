package com.prakash.newsapi.model.response;

import com.prakash.newsapi.model.utllity.Source;
import lombok.Data;

import java.util.List;

@Data
public class SourceResponse{
	private String status;
	private List<Source> sources;
}
