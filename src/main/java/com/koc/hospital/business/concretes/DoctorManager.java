package com.koc.hospital.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koc.hospital.business.abstracts.DoctorService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.core.utilities.results.SuccessDataResult;
import com.koc.hospital.core.utilities.results.SuccessResult;
import com.koc.hospital.dataAccess.abstracts.DoctorRepository;
import com.koc.hospital.entities.concretes.Doctor;

@Service
public class DoctorManager implements DoctorService {

	private DoctorRepository doctorRepository;
	
	@Autowired
	public DoctorManager(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public Result add(Doctor doctor) {
		this.doctorRepository.save(doctor);
		return new SuccessResult("Doctor eklendi");
	}

	@Override
	public Result update(Doctor doctor) {
		this.doctorRepository.save(doctor);
		return new SuccessResult("Doctor update edildi");
	}

	@Override
	public Result delete(int id) {
	this.doctorRepository.deleteById(id);
	return new SuccessResult("Doktor silindi");
	}

	@Override
	public DataResult<List<Doctor>> getAll() {
	return new SuccessDataResult<List<Doctor>>(this.doctorRepository.findAll());
	}

	@Override
	public DataResult<Doctor> getById(int id) {
		return new SuccessDataResult<Doctor>(this.doctorRepository.getById(id));
	}

	@Override
	public DataResult<List<Doctor>> getByGender_Id(int genderId) {
		return new SuccessDataResult<List<Doctor>>(this.doctorRepository.getByGender_Id(genderId));
	}

	@Override
	public DataResult<List<Doctor>> getByDepartment_Id(int departmentId) {
		return new SuccessDataResult<List<Doctor>>(this.doctorRepository.getByDepartment_Id(departmentId));
	}

	@Override
	public DataResult<List<Doctor>> getByAgeGreaterThan(int age) {
		return new SuccessDataResult<List<Doctor>> (this.doctorRepository.getByAgeGreaterThan(age));
	}

	@Override
	public DataResult<List<Doctor>> getByAgeLessThan(int age) {
	return new SuccessDataResult<List<Doctor>> (this.doctorRepository.getByAgeLessThan(age));
	}

	
	
}
