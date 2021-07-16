package com.koc.hospital.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="addresses")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="district_name")
	private String districtName;
	
	@Column(name="street_name")
	private String streetName;
	
	@Column(name="building_number")
	private short buildingNumber;
	
	@Column(name="door_number")
	private short doorNumber;
	
	@Column(name="post_code")
	private int postCode;
	
	@OneToOne(
		    mappedBy = "address",
		    orphanRemoval = true,
		    cascade = CascadeType.ALL)
		private Doctor doctor;
	
	@OneToOne(
		    mappedBy = "address",
		    orphanRemoval = true,
		    cascade = CascadeType.ALL)
		private Patient patient;
	
}
