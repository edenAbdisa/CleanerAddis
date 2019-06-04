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
@Table(name = "replied_comment")
@Data
@RequiredArgsConstructor
public class RepliedComment implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="uuid")
	private UUID uuid;
	
	 
	@Column(name="main_comment_uuid")
	private UUID mainCommentUuid;
	
	 
	@Column(name="reply_comment_uuid")
	private UUID replyCommentUuid;
	
 
	@Column(name="replied_commentcol")
	private String repliedCommentCol;
}
