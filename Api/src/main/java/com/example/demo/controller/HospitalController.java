package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hospital;
import com.example.demo.service.HospitalService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/patients")
public class HospitalController {

	@Autowired 
	HospitalService hospitalService;
	@Operation(summary="Creates a new patient record")
	@ApiResponses(value= {@ApiResponse(responseCode ="201",description ="record created successfully"),
	@ApiResponse(responseCode ="400",description ="patient details is invalid")})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Hospital>create (final @RequestBody Hospital hospital)
	{
		Hospital createHospital= hospitalService.create(hospital);
		return ResponseEntity.ok(createHospital);
	}
	@Operation(summary="Gets a patient record")

	@ApiResponses(value= {@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="patient not found")
	})

	@GetMapping(value="/{id}",produces="application/json")
	public ResponseEntity<Optional<Hospital>> read(final @PathVariable Long id){
		Optional<Hospital> createdHospital=hospitalService.read(id);
		return ResponseEntity.ok(createdHospital);
	}

	@Operation(summary="Updates a new patient record")

	@ApiResponses(value= {@ApiResponse(responseCode="200",description="pateint record updated successfully"),
			@ApiResponse(responseCode="400",description="patient details is invalid"),@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="patient not found")
	})

	@PutMapping(value="/{id}",produces="application/json",consumes="application/json")
	public ResponseEntity<Hospital> update(final @RequestBody Hospital hospital)throws  JsonProcessingException{
		final Hospital updatedHospital=hospitalService.update(hospital);
		return ResponseEntity.ok(updatedHospital);
	}

	@Operation(summary="Deletes the patient record by given id")

	@ApiResponses(value= {@ApiResponse(responseCode="200",description="patient record deleted successfully"),
			@ApiResponse(responseCode="401",description="invalid credentials"),@ApiResponse(responseCode="404",description="patient not found")})
	@DeleteMapping("/{id}")
	public void delete(final @PathVariable Long id) {
		hospitalService.delete(id);
	}
}

