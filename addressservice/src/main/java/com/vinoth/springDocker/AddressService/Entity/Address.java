package com.vinoth.springDocker.AddressService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Address", uniqueConstraints = @UniqueConstraint(columnNames = {"street","city","country"}))
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int id;
    private String street;
    private String city;
    private String state;
    private String country;
}
