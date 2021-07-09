package com.koc.hospital.business.abstracts;

import java.util.List;

import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Gender;

public interface GenderService {

	Result add (Gender gender);
	Result update(Gender gender);
	
	Result delete(int id);
	
	DataResult<Gender> getById(int id);
	
	DataResult<List<Gender>> getAll();
	
}
