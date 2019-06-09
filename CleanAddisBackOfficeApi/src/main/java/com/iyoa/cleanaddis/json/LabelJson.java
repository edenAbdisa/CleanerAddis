package com.iyoa.cleanaddis.json;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class LabelJson {

	@JsonProperty("label")
	private String label;
}
