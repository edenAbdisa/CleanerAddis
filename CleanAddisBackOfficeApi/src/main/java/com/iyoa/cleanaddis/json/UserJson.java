package com.iyoa.cleanaddis.json;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iyoa.cleanaddis.model.Role;
import com.iyoa.cleanaddis.model.Post.CanBeViewedBy;
import com.iyoa.cleanaddis.model.Post.PostStatus;

import lombok.Data;

@Data
public class UserJson {

	
	@JsonProperty("username")	
	private String username;
	
	@JsonProperty( "fName")	
	private String firstName;
	
	@JsonProperty("lName")	
	private String lastName;
	
	@JsonProperty("email")	
	private String email;
	
	@JsonProperty("password")	
	private String password;
	
	@JsonProperty("phone_no")	
	private String phoneNumber;
	
	@JsonProperty("img_url")	
	private String imagePath;
	
	@JsonProperty("activated")	
	private int isActivated;
	
	@JsonProperty("blocked")	
	private int isBlocked;
	
	@JsonProperty("role_name")
	private String role;
	
	@JsonProperty("last_visit")
	private Date lastVisit;
	
	@JsonProperty("activated_date")
	private Date activatedDate;
	
}
