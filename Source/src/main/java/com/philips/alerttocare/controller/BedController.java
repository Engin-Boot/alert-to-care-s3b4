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

import com.philips.alerttocare.dto.AddBedModel;
import com.philips.alerttocare.dto.ApiResponse;
import com.philips.alerttocare.service.BedService;

@RestController
@RequestMapping(value = "/bed-mgmt")
public class BedController {
	
	@Autowired
	private BedService bedService;
	
	@PostMapping("/bed")
	public ResponseEntity<ApiResponse> addBed(@RequestBody AddBedModel addBedModel) {
		ApiResponse response = bedService.saveBed(addBedModel);
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
			
	}
	
	@GetMapping("/allBeds")
	public ResponseEntity<ApiResponse> getAllBeds() {
		
		return ResponseEntity.status(HttpStatus.OK).body(bedService.getAllBeds());
	
	}
	
	@GetMapping("/bed/{bedId}")
	public ResponseEntity<ApiResponse> getBed(@PathVariable Integer bedId ) {
		ApiResponse response = bedService.getBedbyId(bedId);
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	@DeleteMapping("/bed/{bedId}")
	public ResponseEntity<ApiResponse> deleteBed(@PathVariable Integer bedId ) {
		ApiResponse response = bedService.deleteBed(bedId);
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
}
