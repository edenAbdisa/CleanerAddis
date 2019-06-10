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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.hibernate.annotations.GenericGenerator;


@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "user")
@Data
@RequiredArgsConstructor
public class User implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuid", updatable = false, nullable = false)
	private java.util.UUID uuid;

	
	@Column(name = "username", unique = true, nullable = false, length = 100)	
	private String username;
	
	@Column(name = "f_name", nullable = false, length = 65535)	
	private String firstName;
	
	@Column(name = "l_name", nullable = false, length = 65535)	
	private String lastName;
	
	@Column(name = "email", nullable = false, length = 65535)	
	private String email;
	
	@Column(name = "password", nullable = false, length = 65535)	
	private String password;
	
	@Column(name = "phone_no", nullable = false, length = 65535)	
	private String phoneNumber;
	
	@Column(name = "img_url", nullable = false, length = 65535)	
	private String imagePath;
	
	@Column(name = "activated", nullable = false, length = 65535)	
	private int isActivated;
	
	@Column(name = "blocked", nullable = false, length = 65535)	
	private int isBlocked;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="role_uuid",referencedColumnName="uuid")
	private Role role;
	
	@Column(name = "last_visit", nullable = false, length = 65535)	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastVisit;
	
	@Column(name = "activated_date", nullable = false, length = 65535)
	@Temporal(TemporalType.TIMESTAMP)
	private Date activatedDate;
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
}
	
	

	