package com.koc.hospital.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Image;

public interface ImageService {

	Result add(Image image,MultipartFile imageFile);
	
	Result delete(int id);
	
	Result update(Image image);
	
}
