package com.vinoth.springDocker.AddressService.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinoth.springDocker.AddressService.DTO.AddressDTO;
import com.vinoth.springDocker.AddressService.Entity.Address;
import com.vinoth.springDocker.AddressService.error.AddressException;
import com.vinoth.springDocker.AddressService.service.AddressService;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Logger logger = LogManager.getLogger(AddressController.class);

	@GetMapping("/check")
	public ResponseEntity<String> checkAddress(){
		return new ResponseEntity<>("Checking",HttpStatus.OK); 
	}
	
	@GetMapping(value = "/find/{findById}")
	public ResponseEntity<AddressDTO> findbyId(@PathVariable("findById") int addressId) throws AddressException{
		logger.info("Find by address id : {}",addressId);
		Address address = addressService.findById(addressId);
		AddressDTO addressData = modelMapper.map(address, AddressDTO.class);
		return new ResponseEntity<>(addressData, HttpStatus.OK);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address){
		Address returnAddress = addressService.saveAddress(address);
		return new ResponseEntity<>(returnAddress, HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveAll")
	public ResponseEntity<List<Integer>> saveAddresses(@RequestBody List<Address> addresses){
		List<Integer> addressList = addressService.saveAddresses(addresses);
		return new ResponseEntity<>(addressList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Address>> findAllAddress(){
		List<Address> addresses = addressService.findAllAddress();
		return new ResponseEntity<>(addresses, HttpStatus.OK);
	}
}
