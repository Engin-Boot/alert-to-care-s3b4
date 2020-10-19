package com.philips.alerttocare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philips.alerttocare.dto.ApiResponse;
import com.philips.alerttocare.entity.BedMonitor;
import com.philips.alerttocare.service.BedMonitorService;

@RestController
@RequestMapping(value = "/bed-device")
public class BedMonitorController {


	@Autowired
	private BedMonitorService monitorService;
	
	@PostMapping("/map")
	public ResponseEntity<ApiResponse> addBed(@RequestBody BedMonitor bedMonitor) {
		ApiResponse response = monitorService.mapBedDevice(bedMonitor);
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
			
	}
	
	@PutMapping("/map/{deviceID}")
	public ResponseEntity<ApiResponse> updateBedMonitor(@PathVariable(value = "deviceID") Long deviceID,
			              @RequestBody BedMonitor bedMonitor)
	{
		ApiResponse response = monitorService.updateBedDevice(bedMonitor);
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
			
	}
	
	
	@GetMapping("/allMaps")
	public ResponseEntity<ApiResponse> getAllBeds() {
		ApiResponse response = monitorService.getAllBedMonitors();
		if(response.getStatus()==200) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
	}
}
