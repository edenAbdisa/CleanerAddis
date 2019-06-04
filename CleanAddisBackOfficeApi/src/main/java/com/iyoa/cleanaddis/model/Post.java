package com.iyoa.cleanaddis.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.RequiredArgsConstructor; 


@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "post")
@Data
@RequiredArgsConstructor
public class Post {
	public enum PostStatus {
		   POSTED, REMOVEDBYREPORT,DELETED,EDITED
	}
	public enum CanBeViewedBy {
		    FRIENDS,FRIENDSOFFRIENDS,MEONLY,ALL
	}
		
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="uuid")
	private UUID uuid;
	
	@Column(name="username")
	private String username;
	
	@Column(name="media_uuid")
	private UUID mediaUuid;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="noLike")
	private int noLike;
	
	@Column(name="no_view")
	private int noView;
	
	@Column(name="status")
	private PostStatus status;
	
	@Column(name="downloadable")
	private int downloadable;
	
	@Column(name="can_be_viewed_by")
	private CanBeViewedBy canBeViewedBy;
	
	@Column(name="allow_to_be_used_for_article")
	private int allowToBeUsedForArticle;	
}
 