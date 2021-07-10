package com.koc.hospital.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koc.hospital.business.abstracts.AppointmentService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.core.utilities.results.SuccessDataResult;
import com.koc.hospital.core.utilities.results.SuccessResult;
import com.koc.hospital.dataAccess.abstracts.AppointmentRepository;
import com.koc.hospital.entities.concretes.Appointment;
@Service
public class AppointmentManager implements AppointmentService{

	
	private AppointmentRepository appoinmentRepository;
	
	@Autowired
	public AppointmentManager(AppointmentRepository appoinmentRepository) {
		super();
		this.appoinmentRepository = appoinmentRepository;
	}

	@Override
	public Result add(Appointment appoinment) {
		 this.appoinmentRepository.save(appoinment);
		 return new SuccessResult("Randevu oluşturuldu");
		 
	}

	@Override
	public Result update(Appointment appoinment) {
		this.appoinmentRepository.save(appoinment);
		return new SuccessResult("Randevu güncellendi");
	}

	@Override
	public Result delete(int id) {
	this.appoinmentRepository.deleteById(id);
	return new SuccessResult("randevu silindi");
	}

	@Override
	public DataResult<Appointment> getById(int id) {
		return new SuccessDataResult<Appointment>(this.appoinmentRepository.getById(id));
	}

	@Override
	public DataResult<List<Appointment>> getAll() {
		return new SuccessDataResult<List<Appointment>>(this.appoinmentRepository.findAll());
	}

	@Override
	public DataResult<List<Appointment>> findAllByOrderByDesc() {
		return new SuccessDataResult<List<Appointment>>(this.appoinmentRepository.findAllByOrderByAppoinmentDateDesc());
	}

	@Override
	public DataResult<List<Appointment>> findAllByOrderByAsc() {
	return new SuccessDataResult<List<Appointment>>(this.appoinmentRepository.findAllByOrderByAppoinmentDateAsc());
	}

}
