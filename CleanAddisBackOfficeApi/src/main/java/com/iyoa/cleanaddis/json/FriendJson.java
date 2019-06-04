package com.iyoa.cleanaddis.json;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class FriendJson {


	@JsonProperty("status")
	private String status;

	@JsonProperty("username_requestor")	
	private String requestor;
	
	@JsonProperty("username_acceptor")	
	private String acceptor;
	
}
