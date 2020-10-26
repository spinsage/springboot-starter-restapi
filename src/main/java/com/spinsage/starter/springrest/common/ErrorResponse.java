package com.spinsage.starter.springrest.common;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class ErrorResponse {

	@Getter
	@Setter
	private long code;

	@Getter
	@Setter
	private String type;

	@Getter
	@Setter
	private List<ErrorEntry> errors = new ArrayList<>();

	@Builder
	public static class ErrorEntry {

		@Getter
		@Setter
		private String code;

		@Getter
		@Setter
		private String message;
	}
}
