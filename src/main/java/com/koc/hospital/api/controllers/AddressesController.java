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

import com.koc.hospital.business.abstracts.AddressService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.entities.concretes.Address;

@RestController
@RequestMapping("/api/adress/")
@CrossOrigin
public class AddressesController {

	private AddressService adressService;

	@Autowired
	public AddressesController(AddressService adressService) {
		super();
		this.adressService = adressService;
	}
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Address adress){
		return ResponseEntity.ok(this.adressService.add(adress));
	}
	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody Address adress){
		return ResponseEntity.ok(this.adressService.update(adress));
	}
	@DeleteMapping("delete")
	public ResponseEntity<?> delete( @RequestParam int id){
		return ResponseEntity.ok(this.adressService.delete(id));
	}
	
	@GetMapping("getById")
	public DataResult<Address> getById(@RequestParam int id){
		return this.adressService.getById(id);
	}
	
	@GetMapping("getAll")
	public DataResult <List<Address>> getAll(){
		return this.adressService.getAll();
	}
	
	@GetMapping("getByCityName")
	public DataResult <Address> getByCityName(@RequestParam String cityName){
		return this.adressService.getByCityName(cityName);
	}
	@GetMapping("getByStreetName")
	public DataResult <Address> getByStreetName(@RequestParam String streetName){
		return this.adressService.getByCityName(streetName);
	}
	
	@GetMapping("getByPostCode")
	public DataResult <Address> getByPostCode(@RequestParam int postCode){
		return this.adressService.getByPostCode(postCode);
	}
	

}
