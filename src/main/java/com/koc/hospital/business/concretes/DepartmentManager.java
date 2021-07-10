package com.koc.hospital.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koc.hospital.business.abstracts.DepartmentService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.core.utilities.results.SuccessDataResult;
import com.koc.hospital.core.utilities.results.SuccessResult;
import com.koc.hospital.dataAccess.abstracts.DepartmentRepository;
import com.koc.hospital.entities.concretes.Department;
@Service
public class DepartmentManager implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
	
	@Autowired
	public DepartmentManager(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	
	@Override
	public Result add(Department department) {
		String departmentName=department.getName().toUpperCase();
		department.setName(departmentName);
		this.departmentRepository.save(department);
		return new SuccessResult("Bölüm eklendi");
	}

	
	@Override
	public Result update(Department department) {
	this.departmentRepository.save(department);
	return new SuccessResult("Bölüm güncellendi");
	}

	
	@Override
	public Result delete(int id) {
	this.departmentRepository.deleteById(id);
	return new SuccessResult("Bölüm silindi");
	}

	
	@Override
	public DataResult<Department> getById(int id) {
		return new SuccessDataResult<Department>(this.departmentRepository.getById(id));
	}

	@Override
	public DataResult<List<Department>> getAll() {
		return new SuccessDataResult<List<Department>>(this.departmentRepository.findAll());
	}

	@Override
	public DataResult<Department> getByName(String name) {
	return new SuccessDataResult<Department>(this.departmentRepository.getByName(name.toUpperCase()));
	}

}
