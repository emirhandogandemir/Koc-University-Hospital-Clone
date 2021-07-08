package com.koc.hospital.business.abstracts;

import java.util.List;

import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Education;

public interface EducationService {
	Result add(Education education);
	
	Result update(Education education);
	
	Result delete(int id);
	
	DataResult<List<Education>> getAll();
	
	DataResult<Education> getBySchoolName(String name);
	
}
