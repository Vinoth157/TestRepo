package com.vinoth.springDocker.AddressService.error;

import com.vinoth.springDocker.AddressService.DTO.ExceptionMessages;

import lombok.Getter;

@Getter
public class AddressException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ExceptionMessages exp;

	public AddressException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AddressException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AddressException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AddressException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public AddressException(ExceptionMessages expMsg) {
		super();
		this.exp = expMsg;
	}


	
}
