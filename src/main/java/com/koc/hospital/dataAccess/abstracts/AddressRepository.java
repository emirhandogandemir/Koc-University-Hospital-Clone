package com.koc.hospital.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koc.hospital.entities.concretes.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	Address getById(int id);
	
	Address getByCityName(String name);
	
	Address getByStreetName(String name);
	
	Address getByPostCode(int postCode);
	
}
