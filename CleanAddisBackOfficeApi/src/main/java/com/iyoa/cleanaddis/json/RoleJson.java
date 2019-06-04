package com.iyoa.cleanaddis.json;

import java.sql.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iyoa.cleanaddis.model.Post.CanBeViewedBy;
import com.iyoa.cleanaddis.model.Post.PostStatus;

import lombok.Data;

@Data
public class RoleJson {

	@JsonProperty("role")
	private String role;
}
