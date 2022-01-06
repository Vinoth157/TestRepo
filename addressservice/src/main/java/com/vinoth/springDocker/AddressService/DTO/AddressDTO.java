package com.vinoth.springDocker.AddressService.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private int id;
    private String street;
    private String city;
    private String state;
    private String country;
}
