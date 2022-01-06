package com.vinoth.springDocker.AddressService.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinoth.springDocker.AddressService.DTO.ExceptionMessages;
import com.vinoth.springDocker.AddressService.Entity.Address;
import com.vinoth.springDocker.AddressService.error.AddressException;
import com.vinoth.springDocker.AddressService.repository.AddressRepository;
import com.vinoth.springDocker.AddressService.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Address findById(int addressId) throws AddressException {		
		Optional<Address> address = addressRepository.findById(addressId);
		if(!address.isPresent()) {
			throw new AddressException(ExceptionMessages.NOT_FOUND);
		}
		return address.orElse(null);
	}

	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Integer> saveAddresses(List<Address> addresses) {		
		return addressRepository.saveAll(addresses).stream().map(address -> address.getId()).toList();
	}

	@Override
	public List<Address> findAllAddress() {
		return addressRepository.findAll();
	}

}
