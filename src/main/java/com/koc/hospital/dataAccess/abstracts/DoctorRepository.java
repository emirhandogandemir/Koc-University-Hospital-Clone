package com.koc.hospital.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koc.hospital.entities.concretes.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
