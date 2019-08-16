package com.iyoa.cleanaddis.model;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	 
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="media_uuid",referencedColumnName="uuid")
	private Media media;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="no_like")
	private int noLike;
	
	@Column(name="no_view")
	private int noView;
	
	@Column(name="status")
	private String status;
	
	@Column(name="downloadable")
	private int downloadable;
	
	@Column(name="can_be_viewed_by")
	private String canBeViewedBy;
	
	@Column(name="allow_to_be_used_for_article")
	private int allowToBeUsedForArticle;
	 
	 
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="post_uuid",referencedColumnName="uuid")
	private List<Comment> comment;
	 
}
 