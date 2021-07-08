package com.koc.hospital.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koc.hospital.entities.concretes.Appoinment;

@Repository
public interface AppoinmentRepository extends JpaRepository<Appoinment, Integer> {

}
