package com.koc.hospital.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koc.hospital.entities.concretes.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{

	Image getById(int id);
	
}
