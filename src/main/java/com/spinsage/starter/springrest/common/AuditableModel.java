package com.spinsage.starter.springrest.common;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

public class AuditableModel extends BaseModel {

	@Getter
	@Setter
	@CreatedDate
	private Date createdDate;

	@Getter
	@Setter
	@LastModifiedDate
	private Date modifiedDate;
}
