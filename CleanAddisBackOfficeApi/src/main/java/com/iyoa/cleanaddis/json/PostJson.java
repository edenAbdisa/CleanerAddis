package com.iyoa.cleanaddis.json;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iyoa.cleanaddis.model.Post.CanBeViewedBy;
import com.iyoa.cleanaddis.model.Post.PostStatus;

import lombok.Data;
@Data
public class PostJson {	
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("mediaUuid")
	private UUID mediaUuid;
	
	@JsonProperty("date")
	private Date date;
	
	@JsonProperty("noLike")
	private int noLike;
	
	@JsonProperty("noView")
	private int noView;
	
	@JsonProperty("status")
	private PostStatus status;
	
	@JsonProperty("downloadable")
	private int downloadable;
	
	@JsonProperty("canBeViewedBy")
	private CanBeViewedBy canBeViewedBy;
	
	@JsonProperty("allowToBeUsedForArticle")
	private int allowToBeUsedForArticle;	
}
