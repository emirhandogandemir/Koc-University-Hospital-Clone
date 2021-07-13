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

import com.koc.hospital.business.abstracts.PatientService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Patient;

@RestController
@RequestMapping("/api/patient/")
@CrossOrigin
public class PatientsController {

	private PatientService patientService;

	@Autowired
	public PatientsController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Patient patient){
		return ResponseEntity.ok(this.patientService.add(patient));
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Patient patient){
		return ResponseEntity.ok(this.patientService.add(patient));
	}
	@DeleteMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.patientService.delete(id);
	}
	
	@GetMapping("getById")
	public DataResult<Patient> getById(@RequestParam int id){
		return this.patientService.getById(id);
	}
	@GetMapping("getAll")
	public DataResult<List<Patient>> getAll(){
		return this.patientService.getAll();
	}
	
	@GetMapping("getByName") 
	public DataResult<Patient> getByName(@RequestParam String name){
		return this.patientService.getByName(name);
	}
	@GetMapping("getByAgeGreaterThan")
	public DataResult<List<Patient>> getByAgeGreaterThan(@RequestParam int age){
		return this.patientService.getByAgeGreaterThan(age);
	}
	
	@GetMapping("getByEmail")
	public DataResult<Patient> getByEmail(@RequestParam String email){
		return this.patientService.getByEmail(email);
	}


}
