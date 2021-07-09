package com.koc.hospital.business.abstracts;

import java.util.List;

import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Patient;

public interface PatientService {
	Result add(Patient patient);

	Result update(Patient patient);

	Result delete(int id);

	DataResult<Patient> getById(int id);

	DataResult<List<Patient>> getAll();

	DataResult<Patient> getByName(String name);

	DataResult<List<Patient>> getByAgeGreaterThan(int age);

	DataResult<Patient> getByEmail(String email);
}
