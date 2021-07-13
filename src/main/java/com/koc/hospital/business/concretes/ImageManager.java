package com.koc.hospital.business.concretes;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koc.hospital.business.abstracts.ImageService;
import com.koc.hospital.core.utilities.imageUpload.ImageUploadService;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.core.utilities.results.SuccessResult;
import com.koc.hospital.dataAccess.abstracts.ImageRepository;
import com.koc.hospital.entities.concretes.Image;
@Service
public class ImageManager implements ImageService {

	private ImageRepository imageRepository;
	private ImageUploadService imageUploadService;
	
	@Autowired
	public ImageManager(ImageRepository imageRepository,ImageUploadService imageUploadService) {
		super();
		this.imageRepository = imageRepository;
		this.imageUploadService=imageUploadService;
	}

	@Override
	public Result add(Image image, MultipartFile imageFile) {
		Map<String,String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
		image.setUrl(uploadImage.get("url"));
		this.imageRepository.save(image);
		return new SuccessResult("Image has been added.");
	}
	

	@Override
	public Result delete(int id) {
		this.imageRepository.deleteById(id);
		return new SuccessResult(id+" li resim silindi");
	}

	@Override
	public Result update(Image image) {
	this.imageRepository.save(image);
	return new SuccessResult("image update edildi");
	}




}
