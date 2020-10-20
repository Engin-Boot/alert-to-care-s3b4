package com.philips.alerttocare.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.philips.alerttocare.dto.AddIcuModel;
import com.philips.alerttocare.dto.ApiResponse;
import com.philips.alerttocare.service.IcuService;


@RestController
@RequestMapping(value = "/icu-mgmt")
public class IcuController {
	
	@Autowired
	private IcuService icuService;
	
	@GetMapping("/icu")
	public ResponseEntity<ApiResponse> getIcus() {
		ApiResponse response = icuService.getIcus();
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

	}
	
	@PostMapping("/icu")
	public ResponseEntity<ApiResponse> addIcu(@RequestBody AddIcuModel addIcuModel) {
		ApiResponse response = icuService.addIcu(addIcuModel);
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
}
