package com.vinoth.springDocker.AddressService.service;

import java.util.List;

import com.vinoth.springDocker.AddressService.Entity.Address;
import com.vinoth.springDocker.AddressService.error.AddressException;

public interface AddressService {

	Address findById(int addressId) throws AddressException;
	Address saveAddress(Address address);
	List<Integer> saveAddresses(List<Address> addresses);
	List<Address> findAllAddress();
}
