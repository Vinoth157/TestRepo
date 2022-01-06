package com.vinoth.springDocker.AddressService.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.vinoth.springDocker.AddressService.Entity.Address;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestEntityManager
class AddressRepositoryTest {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	Address address2 = Address.builder().street("15 Harbort Lane")
			.country("US")
			.state("Texas")
			.city("Roanoke").build();

	@BeforeEach
	void setUp() throws Exception {
		Address address = Address.builder().street("7588 Dakota Hill")
				.country("US")
				.state("Louisiana")
				.city("Flushing").build();
		testEntityManager.persist(address);
		
	}

	@Test
	@DisplayName("Test method for finding all")
	void testFindAll() {
		List<Address> addressList = addressRepository.findAll();
		assertTrue(addressList.stream().anyMatch(address -> {return address.getCity()=="Flushing";}));
	}
	
	@Test
	@DisplayName("Test method for saving the address")
	void testSaveAddress() {
		Address address = addressRepository.save(address2);
		assertEquals("Roanoke", address.getCity());
	}

}
