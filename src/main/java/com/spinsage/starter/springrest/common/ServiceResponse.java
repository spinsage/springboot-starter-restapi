package com.spinsage.starter.springrest.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class ServiceResponse implements Serializable {

	public static enum Status {
		SUCCESS, FAILURE
	}

	@Getter
	@Setter
	private Status status;

	@Getter
	@Setter
	private String message;

	public ServiceResponse(Status status) {
		super();
		this.status = status;
	}

	public ServiceResponse(Status status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

}
