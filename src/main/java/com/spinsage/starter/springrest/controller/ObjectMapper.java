package com.spinsage.starter.springrest.controller;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.spinsage.starter.springrest.dto.DemoProduct;
import com.spinsage.starter.springrest.dto.DemoProductResponse;
import com.spinsage.starter.springrest.model.DemoProductModel;

@Mapper(componentModel = "spring")
public interface ObjectMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "modifiedDate", ignore = true)
	DemoProductModel productToProductModel(DemoProduct product);

	DemoProduct productModelToProduct(DemoProductModel productModel);

	void updateProductModelToResponse(DemoProductModel productModel,
			@MappingTarget DemoProductResponse productResponse);
}
