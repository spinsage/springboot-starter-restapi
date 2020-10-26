package com.spinsage.starter.springrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.spinsage.starter.springrest.common.AuditableModel;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "spinsage_foo")
public class DemoProductModel extends AuditableModel {

	@Getter
	@Setter
	@Column(name = "name", nullable = false)
	private String name;

	@Getter
	@Setter
	@Column(name = "description", nullable = false)
	private String description;

	@Getter
	@Setter
	@Column(name = "inventory", nullable = false)
	private Long inventory;

	public void updateValues(DemoProductModel productModel) {
		this.name = productModel.getName();
		this.description = productModel.getDescription();
		this.inventory = productModel.getInventory();

	}

}
