package com.spinsage.starter.springrest.common;

import lombok.Getter;

public enum ResponseStatusCodes {

	GENERIC_SUCCESS(200, "Operation successful"), GENERIC_FAILURE(400, "Operation failed"),
	ERROR_CREATE_PRODUCT_GENERAL_ERROR(401, "An error occured during product creation"),
	ERROR_INVALID_PRODUCT(401, "Invalid Product");

	@Getter
	private int code;

	@Getter
	private String message;

	ResponseStatusCodes(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
