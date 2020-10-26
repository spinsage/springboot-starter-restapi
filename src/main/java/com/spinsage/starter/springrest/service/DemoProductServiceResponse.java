package com.spinsage.starter.springrest.service;

import com.spinsage.starter.springrest.common.ServiceResponse;
import com.spinsage.starter.springrest.model.DemoProductModel;

import lombok.Getter;
import lombok.Setter;

public class DemoProductServiceResponse extends ServiceResponse {

	public DemoProductServiceResponse(Status status) {
		super(status);
	}

	@Getter
	@Setter
	private DemoProductModel productModel;

	@Getter
	@Setter
	private boolean productFound;

}
