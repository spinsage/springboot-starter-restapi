package com.spinsage.starter.springrest.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spinsage.starter.springrest.common.BaseResponse;
import com.spinsage.starter.springrest.common.ResponseStatusCodes;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoProductResponse extends BaseResponse {

	public DemoProductResponse() {
		super();
	}

	public DemoProductResponse(ResponseStatusCodes errorCode) {
		super(errorCode);
	}

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
