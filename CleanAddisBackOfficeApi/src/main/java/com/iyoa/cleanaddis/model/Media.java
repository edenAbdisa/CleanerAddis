package com.iyoa.cleanaddis.model;



import java.util.Date;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.hibernate.annotations.GenericGenerator;


@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "media")
@Data
 @RequiredArgsConstructor(access = AccessLevel.PUBLIC)
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

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="for_what_data",referencedColumnName="uuid")
	private Label label;

	@Column(name = "description", nullable = false, length = 16777215)
	private String description;
	
	
	
	
	
}
	
	

	