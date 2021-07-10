package com.koc.hospital.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koc.hospital.business.abstracts.EducationService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Education;

@RestController
@RequestMapping("/api/education/")
public class EducationsController {

	private EducationService educationService;

	
	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Education education){
		return  ResponseEntity.ok(this.educationService.add(education)) ;
	}
	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Education education){
		return ResponseEntity.ok(this.educationService.update(education));
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.educationService.delete(id);
	}
	
	@GetMapping("getById")
	public DataResult<Education> getById(@RequestParam int id){
		return this.educationService.getById(id);
	}
	
	@GetMapping("getAll")
	public DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}
	
	@GetMapping("getBySchoolName")
	public DataResult<Education> getBySchoolName(@RequestParam String schoolName){
		return this.educationService.getBySchoolName(schoolName);
	}
	
	
}
