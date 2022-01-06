package com.vinoth.springDocker.AddressService.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vinoth.springDocker.AddressService.DTO.ExceptionResponse;
@RestControllerAdvice
public class AddressExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AddressException.class)
	public ResponseEntity<ExceptionResponse> addressException(Exception e){
		ExceptionResponse expMsg = new ExceptionResponse(((AddressException)e).getExp().getErrorCode(),((AddressException)e).getExp().getErrorDesc());
		return ResponseEntity.status(((AddressException)e).getExp().getErrorCode()).body(expMsg);
	}
}
