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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.hibernate.annotations.GenericGenerator;


@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "report")
@Data
@RequiredArgsConstructor
public class Report implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuid", updatable = false, nullable = false)
	private java.util.UUID uuid;

	
	@Column(name = "username", unique = true, nullable = false, length = 100)	
	private String username;
	


	@Column(name = "subject", nullable = false, length = 65535)	
	private String subject;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="media_uuid",referencedColumnName="uuid")
	private Media media;
	
	@Column(name = "report_type", nullable = false, length = 65535)	
	private String reportType;
	
	@Column(name = "date", nullable = false, length = 65535)	
	private Date date;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="address_uuid",referencedColumnName="uuid")
	private Address address;
	
	@Column(name = "impact", nullable = false, length = 65535)	
	private int impact;
	
	
	
	
	
	
	
	
	
	
	
}
	
	

	