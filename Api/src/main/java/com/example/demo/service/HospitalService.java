package com.example.demo.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hospital;
import com.example.demo.repository.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	public Hospital create(Hospital hospital)
	{
		return hospitalRepository.save(hospital);
	}
	 
public Optional<Hospital> read(Long id)
{
	return hospitalRepository.findById(id);
}
public Hospital update(Hospital hospital) {
	return hospitalRepository.save(hospital);
}

public void delete(Long id)
{
	hospitalRepository.deleteById(id);
}


}