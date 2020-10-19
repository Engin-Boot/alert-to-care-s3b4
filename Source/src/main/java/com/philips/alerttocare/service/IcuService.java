package com.philips.alerttocare.service;

import com.philips.alerttocare.dto.AddIcuModel;
import com.philips.alerttocare.dto.ApiResponse;

public interface IcuService {
	
	ApiResponse addIcu(AddIcuModel addIcuModel);
	
	ApiResponse getIcus();
}
