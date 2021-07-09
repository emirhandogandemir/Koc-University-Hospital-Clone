package com.koc.hospital.business.abstracts;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Doctor;

public interface DoctorService {

	Result add(Doctor doctor);
	
	Result update(Doctor doctor);
	
	Result delete(int id);
	
	DataResult<List<Doctor>> getAll();
	
	DataResult<Doctor> getById(int id);
	
	DataResult<List<Doctor>> getByGender_Id(int genderId);
	
	DataResult<List<Doctor>> getByDepartment_Id(int departmentId);
	
	DataResult<List<Doctor>> getByAgeGreaterThan(int age);
	
	DataResult<List<Doctor>> getByAgeLessThan(int age);
}
