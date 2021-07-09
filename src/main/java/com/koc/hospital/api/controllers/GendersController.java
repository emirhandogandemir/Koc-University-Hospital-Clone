package com.koc.hospital.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koc.hospital.business.abstracts.GenderService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Gender;

@RestController
@RequestMapping("/api/gender/")
@CrossOrigin
public class GendersController {

	private GenderService genderService;

	@Autowired
	public GendersController(GenderService genderService) {
		super();
		this.genderService = genderService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Gender gender){
		return  ResponseEntity.ok(this.genderService.add(gender)) ;
	}
	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Gender gender){
		return ResponseEntity.ok(this.genderService.update(gender));
	}
	
	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.genderService.delete(id);
	}
	
	@GetMapping("getById")
	public DataResult<Gender> getById(@RequestParam int id){
		return this.genderService.getById(id);
	}
	
	@GetMapping("getAll")
	public DataResult<List<Gender>> getAll(){
		return this.genderService.getAll();
	}
}
