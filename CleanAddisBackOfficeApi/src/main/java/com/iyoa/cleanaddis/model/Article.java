package com.iyoa.cleanaddis.model;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "article")
@Data
@RequiredArgsConstructor
public class Article implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuid", updatable = false, nullable = false)
	private java.util.UUID uuid;

	
	@Column(name = "title", unique = true, nullable = false, length = 100)	
	private String title;
	

	@Column(name = "text", nullable = false, length = 65535)	
	private String text;

	@Column(name = "published_date",  length = 16777215)
	private Date publishedDate;
	
	@Column(name = "published_status", nullable = false, length = 16777215)
	private String publishedStatus;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="updated_by",referencedColumnName="username")
	private User updater;
	
	@Column(name = "updated_date", length = 16777215)
	private Date updatedDate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="published_by",referencedColumnName="username")
	private User publisher;
	
	@Column(name = "view_count", nullable = false, length = 16777215)
	private int viewCount;
	
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="media_uuid",referencedColumnName="uuid")
	private Media media;

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category_uuid",referencedColumnName="uuid")
	private Category category;
	
}
	
	

	