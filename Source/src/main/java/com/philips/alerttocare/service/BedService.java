package com.philips.alerttocare.service;


import com.philips.alerttocare.dto.AddBedModel;
import com.philips.alerttocare.dto.ApiResponse;

public interface BedService {
	
	ApiResponse saveBed(AddBedModel addBedModel);
	ApiResponse getAllBeds();
	ApiResponse getBedbyId(Integer id);
	ApiResponse deleteBed(Integer id);
}
