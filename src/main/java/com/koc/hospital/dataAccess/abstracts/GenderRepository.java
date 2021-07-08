package com.koc.hospital.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koc.hospital.entities.concretes.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {

}
