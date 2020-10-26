package com.spinsage.starter.springrest.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spinsage.starter.springrest.common.BaseRequest;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoProduct extends BaseRequest {

	@Getter
	@Setter
	@NotBlank
	private String name;

	@Getter
	@Setter
	private String description;

	@Getter
	@Setter
	private Long inventory;

}
