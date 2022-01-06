package com.vinoth.springDocker.AddressService.DTO;

import lombok.Getter;

@Getter
public enum ExceptionMessages {

	NOT_FOUND(404, "Data Not Found");

	private int errorCode;
	private String errorDesc;
	ExceptionMessages(int errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDesc = errorDescription;
	}
	
}
