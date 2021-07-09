package com.koc.hospital.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koc.hospital.business.abstracts.GenderService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.core.utilities.results.SuccessDataResult;
import com.koc.hospital.core.utilities.results.SuccessResult;
import com.koc.hospital.dataAccess.abstracts.GenderRepository;
import com.koc.hospital.entities.concretes.Gender;
@Service
public class GenderManager implements GenderService {

	private GenderRepository genderRepository;
	
	@Autowired
	public GenderManager(GenderRepository genderRepository) {
		super();
		this.genderRepository = genderRepository;
	}

	@Override
	public Result add(Gender gender) {
		this.genderRepository.save(gender);
		return new SuccessResult ("Cinsiyet ekleme başarı ile tamamlandı");
	}

	@Override
	public Result update(Gender gender) {
		this.genderRepository.save(gender);
		return new SuccessResult("Cinsiyet update edildi");
	}

	@Override
	public Result delete(int id) {
		this.genderRepository.deleteById(null);
		return new SuccessResult ("Cinsiyet silindi");
	}

	@Override
	public DataResult<Gender> getById(int id) {
	return new SuccessDataResult<Gender>(this.genderRepository.getById(id));
	}

	@Override
	public DataResult<List<Gender>> getAll() {
	return new SuccessDataResult<List<Gender>>(this.genderRepository.findAll());
	}

}
