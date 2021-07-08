package com.koc.hospital.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.koc.hospital.business.abstracts.DepartmentService;
import com.koc.hospital.entities.concretes.Department;

@RestController
@RequestMapping("/api/department/")
public class DepartmentsController {

	private DepartmentService departmentService;

	@Autowired
	public DepartmentsController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Department department){
		return ResponseEntity.ok(this.departmentService.add(department));
	} 
	
	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Department department){
		return ResponseEntity.ok(this.departmentService.update(department));
	} 
	
	@PostMapping("delete")
	public ResponseEntity<?> update(@RequestParam int id){
		return ResponseEntity.ok(this.departmentService.delete(id));
	} 
	
	@GetMapping("getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		return ResponseEntity.ok(this.departmentService.getById(id));
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.departmentService.getAll());
	}
	
	@GetMapping("getByName")
	public ResponseEntity<?> getByName(@RequestParam String name){
		return ResponseEntity.ok(this.departmentService.getByName(name));
	}
}
