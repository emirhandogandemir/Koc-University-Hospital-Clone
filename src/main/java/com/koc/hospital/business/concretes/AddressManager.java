package com.koc.hospital.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koc.hospital.business.abstracts.AddressService;
import com.koc.hospital.core.utilities.results.DataResult;
import com.koc.hospital.core.utilities.results.Result;
import com.koc.hospital.core.utilities.results.SuccessDataResult;
import com.koc.hospital.core.utilities.results.SuccessResult;
import com.koc.hospital.dataAccess.abstracts.AddressRepository;
import com.koc.hospital.entities.concretes.Address;
@Service
public class AddressManager implements AddressService {

	private AddressRepository adressRepository;
	
	@Autowired
	public AddressManager(AddressRepository adressRepository) {
		super();
		this.adressRepository = adressRepository;
	}

	@Override
	public Result add(Address adress) {
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
	public Result update(Address adress) {
		this.adressRepository.save(adress);
		return new SuccessResult("Adress güncellendi");
	}

	@Override
	public DataResult<Address> getById(int id) {
		return new SuccessDataResult<Address>(this.adressRepository.getById(id));
	}

	@Override
	public DataResult<List<Address>> getAll() {
		return new SuccessDataResult<List<Address>>(this.adressRepository.findAll());
		
	}

	@Override
	public DataResult<Address> getByCityName(String name) {
		return new SuccessDataResult<Address> (this.adressRepository.getByCityName(name.toUpperCase()));
	}

	@Override
	public DataResult<Address> getByStreetName(String name) {
		return new SuccessDataResult<Address>(this.adressRepository.getByStreetName(name.toUpperCase()));
	}

	@Override
	public DataResult<Address> getByPostCode(int postCode) {
		return new SuccessDataResult<Address> (this.adressRepository.getByPostCode(postCode));
	}
	

}
