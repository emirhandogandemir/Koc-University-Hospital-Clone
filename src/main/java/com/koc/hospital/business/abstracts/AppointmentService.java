package com.koc.hospital.business.abstracts;

import java.util.List;

import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Appointment;

public interface AppointmentService {
	Result add(Appointment appoinment);

	Result update(Appointment appoinment);

	Result delete(int id);
	
	DataResult<Appointment>  getById(int id);
	
	DataResult<List<Appointment>> getAll();
	
	//DataResult<List<Appoinment>> findAllByAppoinmentDate(Date appoinmentTimeStart, Date appoinmentTimeFinish);

	DataResult<List<Appointment>> findAllByOrderByDesc();
	
	DataResult<List<Appointment>> findAllByOrderByAsc();
 }
