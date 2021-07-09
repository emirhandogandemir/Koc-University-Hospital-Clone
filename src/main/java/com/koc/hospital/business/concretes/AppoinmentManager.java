package com.koc.hospital.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koc.hospital.business.abstracts.AppoinmentService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.core.utilities.results.SuccessDataResult;
import com.koc.hospital.core.utilities.results.SuccessResult;
import com.koc.hospital.dataAccess.abstracts.AppoinmentRepository;
import com.koc.hospital.entities.concretes.Appoinment;
@Service
public class AppoinmentManager implements AppoinmentService{

	
	private AppoinmentRepository appoinmentRepository;
	
	@Autowired
	public AppoinmentManager(AppoinmentRepository appoinmentRepository) {
		super();
		this.appoinmentRepository = appoinmentRepository;
	}

	@Override
	public Result add(Appoinment appoinment) {
		 this.appoinmentRepository.save(appoinment);
		 return new SuccessResult("Randevu oluşturuldu");
		 
	}

	@Override
	public Result update(Appoinment appoinment) {
		this.appoinmentRepository.save(appoinment);
		return new SuccessResult("Randevu güncellendi");
	}

	@Override
	public Result delete(int id) {
	this.appoinmentRepository.deleteById(id);
	return new SuccessResult("randevu silindi");
	}

	@Override
	public DataResult<Appoinment> getById(int id) {
		return new SuccessDataResult<Appoinment>(this.appoinmentRepository.getById(id));
	}

	@Override
	public DataResult<List<Appoinment>> getAll() {
		return new SuccessDataResult<List<Appoinment>>(this.appoinmentRepository.findAll());
	}

	@Override
	public DataResult<List<Appoinment>> findAllByOrderByDesc() {
		return new SuccessDataResult<List<Appoinment>>(this.appoinmentRepository.findAllByOrderByAppoinmentDateDesc());
	}

	@Override
	public DataResult<List<Appoinment>> findAllByOrderByAsc() {
	return new SuccessDataResult<List<Appoinment>>(this.appoinmentRepository.findAllByOrderByAppoinmentDateAsc());
	}

}
