package com.iyoa.cleanaddis.json;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iyoa.cleanaddis.model.Post;
import com.iyoa.cleanaddis.model.User; 

import lombok.Data;
@Data
public class CommentJson {	 
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("postUUID")
	private UUID postUUID;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("noLike")
	private int noLike;
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("commentDate")
	private Date commentDate;
}
