package com.iyoa.cleanaddis.json;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iyoa.cleanaddis.model.Label;

import lombok.Data;

@Data
public class MediaJson {
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("type")
	private String type;
	

	@JsonProperty("label")
	private String label;
	
	@JsonProperty("description")
	private String description;
	
}
