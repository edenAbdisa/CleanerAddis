package com.iyoa.cleanaddis.json;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ArticleJson {

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("updater")
	private String updater;
	
	@JsonProperty("publisher")
	private String publisher;
	
	@JsonProperty("published_status")
	private String publishedStatus;
	
	@JsonProperty("view_count")
	private int viewCount;
	
	@JsonProperty("media_uuid")
	private UUID mediaUuid;
	
	@JsonProperty("category_uuid")
	private UUID category_uuid;
	
	
}
