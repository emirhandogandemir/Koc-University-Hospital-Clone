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

import com.koc.hospital.business.abstracts.DoctorService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Doctor;

@RestController
@RequestMapping("/api/doctor/")
@CrossOrigin
public class DoctorsController {

	private DoctorService doctorService;

	@Autowired
	public DoctorsController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Doctor doctor) {
		return ResponseEntity.ok(this.doctorService.add(doctor));
	}

	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Doctor doctor) {
		return ResponseEntity.ok(this.doctorService.update(doctor));
	}

	@DeleteMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.doctorService.delete(id);

	}

	@GetMapping("getById")
	public DataResult<Doctor> geyById(@RequestParam int id) {
		return this.doctorService.getById(id);
	}

	@GetMapping("getAll")
	public DataResult<List<Doctor>> getAll() {
		return this.doctorService.getAll();
	}

	@GetMapping("getByGenderId")
	public DataResult<List<Doctor>> getByGender_Id(@RequestParam int genderId) {
		return this.doctorService.getByGender_Id(genderId);
	}

	@GetMapping("getByDepartmentId")
	public DataResult<List<Doctor>> getByDepartment_Id(@RequestParam int departmentId) {
		return this.doctorService.getByDepartment_Id(departmentId);
	}

	@GetMapping("getByAgeGreaterThan")
	public DataResult<List<Doctor>> getByAgeGreaterThan(@RequestParam int age) {
		return this.doctorService.getByAgeGreaterThan(age);
	}

	@GetMapping("getByAgeLessThan")
	public DataResult<List<Doctor>> getByAgeLessThan(@RequestParam int age) {
		return this.doctorService.getByAgeLessThan(age);
	}

}
