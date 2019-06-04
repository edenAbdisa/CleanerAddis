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
import lombok.RequiredArgsConstructor;

import org.hibernate.annotations.GenericGenerator;


@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "media")
@Data
@RequiredArgsConstructor
public class Media implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuid", updatable = false, nullable = false)
	private java.util.UUID uuid;

	
	@Column(name = "url", unique = true, nullable = false, length = 100)	
	private String url;
	
	@Column(name = "type", nullable = false, length = 16777215)
	private String type;

	@Column(name = "for_what_data", nullable = false, length = 65535)	
	private String forWhatData;

	@Column(name = "description", nullable = false, length = 16777215)
	private String description;
	
	
	
	
	
}
	
	

	