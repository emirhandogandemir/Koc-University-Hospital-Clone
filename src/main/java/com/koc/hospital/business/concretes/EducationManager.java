package com.koc.hospital.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koc.hospital.business.abstracts.EducationService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.core.utilities.results.SuccessDataResult;
import com.koc.hospital.core.utilities.results.SuccessResult;
import com.koc.hospital.dataAccess.abstracts.EducationRepository;
import com.koc.hospital.entities.concretes.Education;

import net.bytebuddy.asm.Advice.This;
@Service
public class EducationManager implements EducationService {

	private EducationRepository educationRepository;
	
	@Autowired
	public EducationManager(EducationRepository educationRepository) {
		super();
		this.educationRepository = educationRepository;
	}

	@Override
	public Result add(Education education) {
		this.educationRepository.save(education);
		return new SuccessResult("Education eklendi");
	}

	@Override
	public Result update(Education education) {
	this.educationRepository.save(education);
	return new SuccessResult("Education updated");
	}

	@Override
	public Result delete(int id) {
		this.educationRepository.deleteById(id);
		return new SuccessResult("Education silindi");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationRepository.findAll());
	}

	@Override
	public DataResult<Education> getBySchoolName(String name) {
		return new SuccessDataResult<Education> (this.educationRepository.getBySchoolName(name));
	}

	@Override
	public DataResult<Education> getById(int id) {
		return new SuccessDataResult<Education>(this.educationRepository.getById(id));
	}

}
