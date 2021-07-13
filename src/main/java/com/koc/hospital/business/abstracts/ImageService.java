package com.koc.hospital.business.abstracts;

import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.entities.concretes.Image;

public interface ImageService {

	Result add(Image image);
	
	Result delete(int id);
	
	Result update(Image image);
	
}
