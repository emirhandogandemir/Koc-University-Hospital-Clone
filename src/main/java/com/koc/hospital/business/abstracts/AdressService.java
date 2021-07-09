package com.koc.hospital.business.abstracts;

import java.util.List;

import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Adress;

public interface AdressService {

	Result add(Adress adress);
	
	Result delete(int id);
	
	Result update(Adress adress);
	
	DataResult <Adress> getById(int id);
	
	DataResult <List<Adress>> getAll();
	
	DataResult <Adress> getByCityName(String name);
	
	DataResult <Adress> getByStreetName(String name);
	
	DataResult <Adress> getByPostCode(int postCode);
}
