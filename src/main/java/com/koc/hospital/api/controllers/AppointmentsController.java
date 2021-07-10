package com.koc.hospital.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koc.hospital.business.abstracts.AppointmentService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Appointment;

@RestController
@RequestMapping("/api/appoinment/")
@CrossOrigin
public class AppointmentsController {

	private AppointmentService appoinmentService;

	@Autowired
	public AppointmentsController(AppointmentService appoinmentService) {
		super();
		this.appoinmentService = appoinmentService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Appointment appoinment){
		return ResponseEntity.ok(this.appoinmentService.add(appoinment));
	}
	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Appointment appoinment){
		return ResponseEntity.ok(this.appoinmentService.update(appoinment));
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestParam int id) {
	return	this.appoinmentService.delete(id);
		
	}
	
	@GetMapping("getById")
	public DataResult<Appointment> getById(@RequestParam int id){
		return this.appoinmentService.getById(id);
	}
	@GetMapping("getAll")
	public DataResult<List<Appointment>> getAll(){
		return this.appoinmentService.getAll();
	}
	
	@GetMapping("getAllByOrderDataDesc")
	public DataResult<List<Appointment>> findAllByOrderByDesc(){
		return this.appoinmentService.findAllByOrderByDesc();
	}
	
	 @GetMapping("getAllByOrderByAsc")
	 public DataResult<List<Appointment>> findAllByOrderByAsc(){
		 return this.appoinmentService.findAllByOrderByAsc();
	 }
	
	
	
}
