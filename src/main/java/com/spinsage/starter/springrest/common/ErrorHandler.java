package com.spinsage.starter.springrest.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorResponse errorDto = new ErrorResponse();
		errorDto.setType("INVALID_INPUT");
		errorDto.setCode(100);

		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			ErrorResponse.ErrorEntry entry = ErrorResponse.ErrorEntry.builder().code(fieldError.getCode())
					.message(fieldError.getField() + " : " + fieldError.getDefaultMessage()).build();
			errorDto.getErrors().add(entry);
		}

		return super.handleExceptionInternal(ex, errorDto, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		ErrorResponse errorDto = new ErrorResponse();
		errorDto.setType("INVALID_INPUT");
		errorDto.setCode(100);

		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			ErrorResponse.ErrorEntry entry = ErrorResponse.ErrorEntry.builder().code(fieldError.getCode())
					.message(fieldError.getField() + " : " + fieldError.getDefaultMessage()).build();
			errorDto.getErrors().add(entry);
		}

		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}
		return new ResponseEntity<>(errorDto, headers, status);

	}
}
