package com.iyoa.cleanaddis.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class LabelJson {

	@JsonProperty("label")
	private String label;
}
