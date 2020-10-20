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
import com.philips.alerttocare.entity.MonitoringDevice;
import com.philips.alerttocare.service.MonitoringDeviceService;


@RestController
@RequestMapping(value = "/device-mgmt")
public class MonitoringDeviceController {
	
	@Autowired
	private MonitoringDeviceService deviceService;
	
	@GetMapping("/devices")
	public ResponseEntity<ApiResponse> getDevices() {
		ApiResponse response = deviceService.getAllDevice();
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
	}
	
	@PostMapping("/devices")
	public ResponseEntity<ApiResponse> addDevice(@RequestBody MonitoringDevice device) {
		ApiResponse response = deviceService.addDevice(device);
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

	}
	
	@GetMapping("/devices/{deviceId}")
	public ResponseEntity<ApiResponse> getDevice(@PathVariable Long deviceId ) {
		ApiResponse response = deviceService.getDeviceById(deviceId);
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

	}
	
	@DeleteMapping("/patient/{patientId}")
	public ResponseEntity<ApiResponse> deleteDevice(@PathVariable Long deviceId ) {
		ApiResponse response = deviceService.deleteDevice(deviceId);
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}
