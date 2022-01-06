package com.vinoth.springDocker.AddressService.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {

	private int errorCode;
	private String errorDesc;
}
