package com.vinoth.springDocker.AddressService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinoth.springDocker.AddressService.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	List<Address> findAll();
	Address save(Address address);

}
