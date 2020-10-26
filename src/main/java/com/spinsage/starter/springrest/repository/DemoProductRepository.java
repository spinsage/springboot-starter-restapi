package com.spinsage.starter.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spinsage.starter.springrest.model.DemoProductModel;

@Repository
public interface DemoProductRepository extends JpaRepository<DemoProductModel, Long> {

	DemoProductModel findByName(String name);
}
