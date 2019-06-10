package com.iyoa.cleanaddis.data;



import java.util.Date;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.hibernate.annotations.GenericGenerator;


@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "teaching")
@Data
@RequiredArgsConstructor
public class Teaching implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuid", updatable = false, nullable = false)
	private java.util.UUID uuid;

	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="media_uuid",referencedColumnName="uuid")
	private Media media;


	@Column(name = "published_date", nullable = false, length = 65535)	
	private Date publishedDate;
	
	@Column(name = "created_date", nullable = false, length = 65535)	
	private Date createdDate;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="category_uuid",referencedColumnName="uuid")
	private Category category;
	
	@Column(name = "text", nullable = false, length = 65535)	
	private String text;
	
	@Column(name = "status", nullable = false, length = 65535)	
	private String status;
	
	
	
	
	
	
	

	
	
	
	
	
	
}
	
	

	