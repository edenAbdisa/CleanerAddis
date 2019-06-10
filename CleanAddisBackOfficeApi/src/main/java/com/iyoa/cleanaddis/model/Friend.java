package com.iyoa.cleanaddis.data;



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
@Table(name = "friends")
@Data
@RequiredArgsConstructor
public class Friend implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuid", updatable = false, nullable = false)
	private java.util.UUID uuid;

	
	@Column(name = "status", unique = true, nullable = false, length = 100)	
	private String status;
	

	
	@Column(name = "username_requestor", nullable = false, length = 65535)	
	private String requestor;
	
	@Column(name = "username_acceptor", nullable = false, length = 65535)	
	private String acceptor;
	
	

	
	
	
	
	
	
}
	
	

	