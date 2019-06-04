package com.iyoa.cleanaddis.model;



import java.util.Date;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;

import org.hibernate.annotations.GenericGenerator;


@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "article")
//@Data
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

	@Column(name = "full_text", nullable = false, length = 16777215)
	private String fullText;
	
	
	
	@Column(name = "published_date", nullable = false, length = 16777215)
	private Date publishedDate;
	
	@Column(name = "published_status", nullable = false, length = 16777215)
	private String publishedStatus;
	
	@Column(name = "updated_by", nullable = false, length = 16777215)
	private String updatedBy;
	
	@Column(name = "updated_date", nullable = false, length = 16777215)
	private Date updatedDate;
	
	@Column(name = "published_by", nullable = false, length = 16777215)
	private String publishedBy;
	
	@Column(name = "view_count", nullable = false, length = 16777215)
	private int viewCount;
	
	@Column(name = "category_uuid", nullable = false, length = 16777215)
	private UUID categoryUUID;
	
}
	
	

	