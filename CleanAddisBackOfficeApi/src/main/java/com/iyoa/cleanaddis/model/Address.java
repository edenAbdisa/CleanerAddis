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
@Table(name = "address")
@Data
@RequiredArgsConstructor
public class Address implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuid", updatable = false, nullable = false)
	private java.util.UUID uuid;

	
	@Column(name = "country", unique = true, nullable = false, length = 100)	
	private String country;
	
	@Column(name = "city", nullable = false, length = 16777215)
	private String City;

	@Column(name = "subcity", nullable = false, length = 65535)	
	private String subcity;

	@Column(name = "woreda", nullable = false, length = 16777215)
	private String woreda;
	
	@Column(name = "street_name", nullable = false, length = 16777215)
	private String streetName;
	
	
	
	
	
	
}
	
	

	