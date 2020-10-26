package com.spinsage.starter.springrest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spinsage.starter.springrest.common.ServiceResponse.Status;
import com.spinsage.starter.springrest.model.DemoProductModel;
import com.spinsage.starter.springrest.repository.DemoProductRepository;

@Service
public class DemoProductService {

	@Autowired
	DemoProductRepository demoProductRepository;

	public DemoProductServiceResponse createProduct(DemoProductModel productModel) {
		DemoProductServiceResponse productServiceResponse;

		productModel = demoProductRepository.save(productModel);

		productServiceResponse = new DemoProductServiceResponse(Status.SUCCESS);
		productServiceResponse.setProductModel(productModel);

		return productServiceResponse;
	}

	public DemoProductServiceResponse updateProduct(Long productId, DemoProductModel productModel) {
		DemoProductServiceResponse productServiceResponse;
		Optional<DemoProductModel> value = demoProductRepository.findById(productId);
		DemoProductModel savedProductModel;
		if (value.isPresent()) {
			savedProductModel = value.get();
			savedProductModel.updateValues(productModel);
			savedProductModel = demoProductRepository.save(savedProductModel);

			productServiceResponse = new DemoProductServiceResponse(Status.SUCCESS);
			productServiceResponse.setProductFound(true);
			productServiceResponse.setProductModel(savedProductModel);
		} else {
			productServiceResponse = new DemoProductServiceResponse(Status.FAILURE);
			productServiceResponse.setProductFound(false);
		}

		return productServiceResponse;
	}

	public DemoProductServiceResponse getProductById(Long productId) {
		DemoProductServiceResponse productServiceResponse;

		Optional<DemoProductModel> value = demoProductRepository.findById(productId);
		DemoProductModel savedProductModel;
		if (value.isPresent()) {
			savedProductModel = value.get();

			productServiceResponse = new DemoProductServiceResponse(Status.SUCCESS);
			productServiceResponse.setProductFound(true);
			productServiceResponse.setProductModel(savedProductModel);
		} else {
			productServiceResponse = new DemoProductServiceResponse(Status.FAILURE);
			productServiceResponse.setProductFound(false);
		}

		return productServiceResponse;
	}

}
