package com.spinsage.starter.springrest.common;

import lombok.Getter;
import lombok.Setter;

public class BaseResponse {

	@Getter
	@Setter
	private long code;

	@Getter
	@Setter
	private String message = "";

	public BaseResponse() {
		super();
	}

	public BaseResponse(long code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public BaseResponse(ResponseStatusCodes responseCode) {
		this.code = responseCode.getCode();
		this.message = responseCode.getMessage();
	}
}
