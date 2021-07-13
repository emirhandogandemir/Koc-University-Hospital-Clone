package com.koc.hospital.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;

import com.koc.hospital.business.abstracts.ImageService;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.core.utilities.results.SuccessResult;
import com.koc.hospital.dataAccess.abstracts.ImageRepository;
import com.koc.hospital.entities.concretes.Image;

public class ImageManager implements ImageService {

	private ImageRepository imageRepository;
	
	@Autowired
	public ImageManager(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}

	@Override
	public Result add(Image image) {
		this.imageRepository.save(image);
		return new SuccessResult("Resim eklendi");
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
