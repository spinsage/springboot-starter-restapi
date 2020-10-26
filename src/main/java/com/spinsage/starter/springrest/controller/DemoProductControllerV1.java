package com.spinsage.starter.springrest.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spinsage.starter.springrest.common.ResponseStatusCodes;
import com.spinsage.starter.springrest.common.ServiceResponse;
import com.spinsage.starter.springrest.dto.DemoProduct;
import com.spinsage.starter.springrest.dto.DemoProductResponse;
import com.spinsage.starter.springrest.model.DemoProductModel;
import com.spinsage.starter.springrest.service.DemoProductService;
import com.spinsage.starter.springrest.service.DemoProductServiceResponse;

@RestController
@RequestMapping("/api/v1/product")
public class DemoProductControllerV1 {

	private static final Logger logger = LoggerFactory.getLogger(DemoProductControllerV1.class);

	@Autowired
	DemoProductService productService;

	@Autowired
	ObjectMapper objectMapper;

	@PostMapping
	public ResponseEntity<DemoProductResponse> createProduct(@Valid @RequestBody DemoProduct product) {

		DemoProductModel productModel = objectMapper.productToProductModel(product);
		DemoProductServiceResponse createProductServiceResponse = productService.createProduct(productModel);

		if (createProductServiceResponse.getStatus() == ServiceResponse.Status.FAILURE) {
			return ResponseEntity.badRequest()
					.body(new DemoProductResponse(ResponseStatusCodes.ERROR_CREATE_PRODUCT_GENERAL_ERROR));
		} else {

			DemoProductResponse productResponse = new DemoProductResponse(ResponseStatusCodes.GENERIC_SUCCESS);
			objectMapper.updateProductModelToResponse(createProductServiceResponse.getProductModel(), productResponse);
			return ResponseEntity.ok(productResponse);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<DemoProductResponse> updateProduct(@PathVariable("id") String id,
			@Valid @RequestBody DemoProduct product) {

		DemoProductModel productModel = objectMapper.productToProductModel(product);
		DemoProductServiceResponse updateProductServiceResponse = productService.updateProduct(Long.parseLong(id),
				productModel);

		if (updateProductServiceResponse.getStatus() == ServiceResponse.Status.FAILURE) {
			DemoProductResponse productResponse;
			if (!updateProductServiceResponse.isProductFound()) {
				productResponse = new DemoProductResponse(ResponseStatusCodes.ERROR_INVALID_PRODUCT);
			} else {
				productResponse = new DemoProductResponse(ResponseStatusCodes.ERROR_CREATE_PRODUCT_GENERAL_ERROR);
			}

			return ResponseEntity.badRequest().body(productResponse);

		} else {
			DemoProductResponse productResponse = new DemoProductResponse(ResponseStatusCodes.GENERIC_SUCCESS);
			objectMapper.updateProductModelToResponse(updateProductServiceResponse.getProductModel(), productResponse);
			return ResponseEntity.ok(productResponse);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<DemoProductResponse> getProductById(@PathVariable("id") String id) {

		DemoProductServiceResponse getProductServiceResponse = productService.getProductById(Long.parseLong(id));

		if (getProductServiceResponse.getStatus() == ServiceResponse.Status.FAILURE) {
			DemoProductResponse productResponse;
			if (!getProductServiceResponse.isProductFound()) {
				productResponse = new DemoProductResponse(ResponseStatusCodes.ERROR_INVALID_PRODUCT);
			} else {
				productResponse = new DemoProductResponse(ResponseStatusCodes.ERROR_CREATE_PRODUCT_GENERAL_ERROR);
			}

			return ResponseEntity.badRequest().body(productResponse);

		} else {
			DemoProductResponse productResponse = new DemoProductResponse(ResponseStatusCodes.GENERIC_SUCCESS);
			objectMapper.updateProductModelToResponse(getProductServiceResponse.getProductModel(), productResponse);
			return ResponseEntity.ok(productResponse);
		}
	}
}
