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

import com.koc.hospital.business.abstracts.AdressService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.entities.concretes.Adress;

@RestController
@RequestMapping("/api/adress/")
@CrossOrigin
public class AdressesController {

	private AdressService adressService;

	@Autowired
	public AdressesController(AdressService adressService) {
		super();
		this.adressService = adressService;
	}
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Adress adress){
		return ResponseEntity.ok(this.adressService.add(adress));
	}
	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Adress adress){
		return ResponseEntity.ok(this.adressService.update(adress));
	}
	@DeleteMapping("delete")
	public ResponseEntity<?> delete( @RequestParam int id){
		return ResponseEntity.ok(this.adressService.delete(id));
	}
	
	@GetMapping("getById")
	public DataResult<Adress> getById(@RequestParam int id){
		return this.adressService.getById(id);
	}
	
	@GetMapping("getAll")
	public DataResult <List<Adress>> getAll(){
		return this.adressService.getAll();
	}
	
	@GetMapping("getByCityName")
	public DataResult <Adress> getByCityName(@RequestParam String cityName){
		return this.adressService.getByCityName(cityName);
	}
	@GetMapping("getByStreetName")
	public DataResult <Adress> getByStreetName(@RequestParam String streetName){
		return this.adressService.getByCityName(streetName);
	}
	
	@GetMapping("getByPostCode")
	public DataResult <Adress> getByPostCode(@RequestParam int postCode){
		return this.adressService.getByPostCode(postCode);
	}
	

}
