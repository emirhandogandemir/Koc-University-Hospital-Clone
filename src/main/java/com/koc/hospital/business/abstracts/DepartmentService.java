package com.koc.hospital.business.abstracts;

import java.util.List;

import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Department;

public interface DepartmentService {
	Result add(Department department);

	Result update(Department department);
	
	Result delete(int id);
	
	DataResult<Department> getById(int id);
	
	DataResult<List<Department>> getAll();
	
	DataResult<Department> getByName(String name);

}
