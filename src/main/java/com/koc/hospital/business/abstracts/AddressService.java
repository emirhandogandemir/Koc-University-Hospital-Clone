package com.koc.hospital.business.abstracts;

import java.util.List;

import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Address;

public interface AddressService {

	Result add(Address adress);
	
	Result delete(int id);
	
	Result update(Address adress);
	
	DataResult <Address> getById(int id);
	
	DataResult <List<Address>> getAll();
	
	DataResult <Address> getByCityName(String name);
	
	DataResult <Address> getByStreetName(String name);
	
	DataResult <Address> getByPostCode(int postCode);
}
