package com.koc.hospital.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koc.hospital.entities.concretes.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	Appointment getById(int id);
	
	//List<Appoinment> findAllByAppoinmentDate(Date appoinmentTimeStart, Date appoinmentTimeFinish);
	
	List<Appointment> findAllByOrderByAppoinmentDateDesc();
	
	List<Appointment> findAllByOrderByAppoinmentDateAsc();
	
	
}
