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
	
	@JsonProperty("media_uuid")
	private UUID mediaUuid;
	
	@JsonProperty("date")
	private Date date;
	
	@JsonProperty("noLike")
	private int noLike;
	
	@JsonProperty("no_view")
	private int noView;
	
	@JsonProperty("status")
	private PostStatus status;
	
	@JsonProperty("downloadable")
	private int downloadable;
	
	@JsonProperty("can_be_viewed_by")
	private CanBeViewedBy canBeViewedBy;
	
	@JsonProperty("allow_to_be_used_for_article")
	private int allowToBeUsedForArticle;	
}
