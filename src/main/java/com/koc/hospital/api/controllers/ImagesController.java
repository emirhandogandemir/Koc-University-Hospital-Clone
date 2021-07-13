package com.koc.hospital.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.koc.hospital.business.abstracts.ImageService;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Image;

@RestController
@RequestMapping("/api/image/")
public class ImagesController {

	private ImageService imageService;

	@Autowired
	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	

	
	@PostMapping("add")
	public Result add(@RequestParam(value = "imageFile") MultipartFile imageFile) {
		
	Image image = new Image();
		return this.imageService.add(image, imageFile);
	}
	
	
	
	@PostMapping("update")
	public ResponseEntity<?> update(@RequestBody Image image){
		return ResponseEntity.ok(this.imageService.update(image));
	}
	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.imageService.delete(id);
	}
}
