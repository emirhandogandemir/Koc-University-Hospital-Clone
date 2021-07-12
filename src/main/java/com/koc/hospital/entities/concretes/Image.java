package com.koc.hospital.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Column(name = "url")
    @NotNull
    private String url;

    @Column(name = "uploaded_at" , columnDefinition = "Date default CURRENT_DATE")
    private LocalDate uploadedAt;

    @OneToOne(mappedBy="image")
  @JsonIgnore()
    private Doctor doctor;
    
    @OneToOne(mappedBy="image")
    @JsonIgnore()
    private Patient patient;
	
}
