package com.vinoth.springDocker.AddressService.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vinoth.springDocker.AddressService.Entity.Address;
import com.vinoth.springDocker.AddressService.error.AddressException;
import com.vinoth.springDocker.AddressService.repository.AddressRepository;

@SpringBootTest
class AddressServiceImplTest {
	
	@Autowired
	private AddressServiceImpl addressService;
	
	@MockBean
	private AddressRepository addressRepository;
	
	Address address1 = Address.builder().id(1)
			.street("44940 Bluestem Circle")
			.city("Baton Rouge")
			.state("Louisiana")
			.country("United States")
			.build();

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("Test Find by given ID")
	void testFindById() throws AddressException {		
		Mockito.when(addressRepository.findById(1)).thenReturn(Optional.of(address1));
		Address address = addressService.findById(1);
		assertEquals("Baton Rouge", address.getCity());
	}
	
	@Test
	@DisplayName("Test Find by Id which not found")
	void testFindByIdWithException() throws AddressException{
		AddressException addressException = assertThrows(AddressException.class, ()->addressService.findById(0));
		assertEquals("Data Not Found", addressException.getExp().getErrorDesc());
	}

	@Test
	void testSaveAddress() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveAddresses() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllAddress() {
		fail("Not yet implemented");
	}

}
