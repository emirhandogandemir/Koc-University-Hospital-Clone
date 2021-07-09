package com.koc.hospital.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koc.hospital.business.abstracts.AppoinmentService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Appoinment;

@RestController
@RequestMapping("/api/appoinment/")
public class AppoinmentsController {

	private AppoinmentService appoinmentService;

	@Autowired
	public AppoinmentsController(AppoinmentService appoinmentService) {
		super();
		this.appoinmentService = appoinmentService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Appoinment appoinment){
		return ResponseEntity.ok(this.appoinmentService.add(appoinment));
	}
	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Appoinment appoinment){
		return ResponseEntity.ok(this.appoinmentService.update(appoinment));
	}
	
	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
	return	this.appoinmentService.delete(id);
		
	}
	
	@GetMapping("getById")
	public DataResult<Appoinment> getById(@RequestParam int id){
		return this.appoinmentService.getById(id);
	}
	@GetMapping("getAll")
	public DataResult<List<Appoinment>> getAll(){
		return this.appoinmentService.getAll();
	}
	
	@GetMapping("getAllByOrderDataDesc")
	public DataResult<List<Appoinment>> findAllByOrderByDesc(){
		return this.appoinmentService.findAllByOrderByDesc();
	}
	
	 @GetMapping("getAllByOrderByAsc")
	 public DataResult<List<Appoinment>> findAllByOrderByAsc(){
		 return this.appoinmentService.findAllByOrderByAsc();
	 }
	
	
	
}
