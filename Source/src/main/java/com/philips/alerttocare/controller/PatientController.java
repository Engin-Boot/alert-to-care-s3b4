package com.philips.alerttocare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philips.alerttocare.dto.ApiResponse;
import com.philips.alerttocare.entity.Patient;
import com.philips.alerttocare.service.PatientService;

@RestController
@RequestMapping(value = "/patient-mgmt")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/patients")
	public ResponseEntity<ApiResponse>  getPatients() {
		ApiResponse response = patientService.getAllPatients();
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	@PostMapping("/patient")
	public ResponseEntity<ApiResponse>  addPatient(@RequestBody Patient patient) {
		ApiResponse response = patientService.createPatient(patient);
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
	}
	
	@GetMapping("/patient/{patientId}")
	public ResponseEntity<ApiResponse>  getPatient(@PathVariable Long patientId ) {
		ApiResponse response = patientService.getPatientbyId(patientId);
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	@DeleteMapping("/patient/{patientId}")
	public ResponseEntity<ApiResponse>  deletePatient(@PathVariable Long patientId ) {
		ApiResponse response =  patientService.deletePatient(patientId);
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}
