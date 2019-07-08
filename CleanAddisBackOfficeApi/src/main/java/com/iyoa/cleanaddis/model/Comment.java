package com.iyoa.cleanaddis.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
	private UUID post;
	
	@Column(name="status")
	private String status;
	
	@Column(name="no_like")
	private int noLike;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="uuid",referencedColumnName="commentor_uuid")
	private User user;
	
	@Column(name="comment_date")
	private Date commentDate;
	
	
}
