package com.koc.hospital.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koc.hospital.business.abstracts.AdressService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.core.utilities.results.SuccessDataResult;
import com.koc.hospital.core.utilities.results.SuccessResult;
import com.koc.hospital.dataAccess.abstracts.AdressRepository;
import com.koc.hospital.entities.concretes.Adress;
@Service
public class AdressManager implements AdressService {

	private AdressRepository adressRepository;
	
	@Autowired
	public AdressManager(AdressRepository adressRepository) {
		super();
		this.adressRepository = adressRepository;
	}

	@Override
	public Result add(Adress adress) {
		String cityName=adress.getCityName().toUpperCase();
		String district=adress.getDistrictName().toUpperCase();
		String streetName=adress.getStreetName().toUpperCase();
		adress.setCityName(cityName.toUpperCase());
		adress.setDistrictName(district.toUpperCase());
		adress.setStreetName(streetName.toUpperCase());
	this.adressRepository.save(adress);
	
return new SuccessResult("Adress eklendi");
	}

	@Override
	public Result delete(int id) {
		this.adressRepository.deleteById(id);
		return new SuccessResult("Adress silindi");
	}

	@Override
	public Result update(Adress adress) {
		this.adressRepository.save(adress);
		return new SuccessResult("Adress güncellendi");
	}

	@Override
	public DataResult<Adress> getById(int id) {
		return new SuccessDataResult<Adress>(this.adressRepository.getById(id));
	}

	@Override
	public DataResult<List<Adress>> getAll() {
		return new SuccessDataResult<List<Adress>>(this.adressRepository.findAll());
		
	}

	@Override
	public DataResult<Adress> getByCityName(String name) {
		return new SuccessDataResult<Adress> (this.adressRepository.getByCityName(name.toUpperCase()));
	}

	@Override
	public DataResult<Adress> getByStreetName(String name) {
		return new SuccessDataResult<Adress>(this.adressRepository.getByStreetName(name.toUpperCase()));
	}

	@Override
	public DataResult<Adress> getByPostCode(int postCode) {
		return new SuccessDataResult<Adress> (this.adressRepository.getByPostCode(postCode));
	}
	

}
