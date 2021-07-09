package com.koc.hospital.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koc.hospital.business.abstracts.PatientService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.core.utilities.results.SuccessDataResult;
import com.koc.hospital.core.utilities.results.SuccessResult;
import com.koc.hospital.dataAccess.abstracts.PatientRepository;
import com.koc.hospital.entities.concretes.Patient;

@Service
public class PatientManager implements PatientService {

	private PatientRepository patientRepository;
	
	@Autowired
	public PatientManager(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public Result add(Patient patient) {
	this.patientRepository.save(patient);
	return new SuccessResult("Hasta ekleme başarılı");
	}

	@Override
	public Result update(Patient patient) {
		this.patientRepository.save(patient);
		return new SuccessResult("Hasta güncelleme başarılı");
	}

	@Override
	public Result delete(int id) {
		this.patientRepository.deleteById(id);
		return new SuccessResult("Hasta silme işlemi başarılı");
	}

	@Override
	public DataResult<Patient> getById(int id) {
		return new SuccessDataResult<Patient>(this.patientRepository.getById(id));
	}

	@Override
	public DataResult<List<Patient>> getAll() {
		return new SuccessDataResult<List<Patient>>(this.patientRepository.findAll());
	}

	@Override
	public DataResult<Patient> getByName(String name) {
		return new SuccessDataResult<Patient>(this.patientRepository.getByName(name));
	}

	@Override
	public DataResult<List<Patient>> getByAgeGreaterThan(int age) {
		return new SuccessDataResult<List<Patient>>(this.patientRepository.getByAgeGreaterThan(age));
	}

	@Override
	public DataResult<Patient> getByEmail(String email) {
	return new SuccessDataResult<Patient>(this.patientRepository.getByEmail(email));
	}

}
