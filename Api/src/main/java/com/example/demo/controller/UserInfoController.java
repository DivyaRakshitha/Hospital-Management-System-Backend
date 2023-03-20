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

import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/userinfo")
public class UserInfoController {

	@Autowired 
	UserInfoService uService;
	@Operation(summary="Creates a new patient record")
	@ApiResponses(value= {@ApiResponse(responseCode ="201",description ="record created successfully"),
	@ApiResponse(responseCode ="400",description ="patient details is invalid")})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<UserInfo>create (final @RequestBody UserInfo UserInfo)
	{
		UserInfo createUserInfo= uService.create(UserInfo);
		return ResponseEntity.ok(createUserInfo);
	}
	@Operation(summary="Gets a patient record")

	@ApiResponses(value= {@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="patient not found")
	})

	@GetMapping(value="/{id}",produces="application/json")
	public ResponseEntity<Optional<UserInfo>> read(final @PathVariable int id){
		Optional<UserInfo> createdUserInfo=uService.read(id);
		return ResponseEntity.ok(createdUserInfo);
	}

	@Operation(summary="Updates a new patient record")

	@ApiResponses(value= {@ApiResponse(responseCode="200",description="pateint record updated successfully"),
			@ApiResponse(responseCode="400",description="patient details is invalid"),@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="patient not found")
	})

	@PutMapping(value="/{id}",produces="application/json",consumes="application/json")
	public ResponseEntity<UserInfo> update(final @RequestBody UserInfo UserInfo)throws  JsonProcessingException{
		final UserInfo updatedUserInfo=uService.update(UserInfo);
		return ResponseEntity.ok(updatedUserInfo);
	}

	@Operation(summary="Deletes the patient record by given id")

	@ApiResponses(value= {@ApiResponse(responseCode="200",description="patient record deleted successfully"),
			@ApiResponse(responseCode="401",description="invalid credentials"),@ApiResponse(responseCode="404",description="patient not found")})
	@DeleteMapping("/{id}")
	public void delete(final @PathVariable int id) {
		uService.delete(id);
	}
}
