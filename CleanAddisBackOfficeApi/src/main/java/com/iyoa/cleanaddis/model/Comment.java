package com.iyoa.cleanaddis.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iyoa.cleanaddis.model.Post.CanBeViewedBy;
import com.iyoa.cleanaddis.model.Post.PostStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "comment")
@Data
@RequiredArgsConstructor
public class Comment {
	
	 enum commentStatus {
		 REPLIED,UPDATED} 
	 
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="uuid")
	private UUID uuid;
	
	@Column(name="text")
	private String text;
	
	@Column(name="post_uuid")
	private UUID postUuid;
	
	@Column(name="status")
	private commentStatus status;
	
	@Column(name="no_like")
	private int noLike;
	
	@Column(name="commentor_uuid")
	private UUID commentorUuid;
	
	@Column(name="comment_date")
	private Date commentDate;
	
	
}
