package com.philips.alerttocare.service;

import com.philips.alerttocare.dto.ApiResponse;
import com.philips.alerttocare.entity.MonitoringDevice;

public interface MonitoringDeviceService {
	
	ApiResponse addDevice(MonitoringDevice monitoringDevice);
	ApiResponse getAllDevice();
	ApiResponse updateDevice(Long deviceId);
	ApiResponse getDeviceById(Long deviceId);
	ApiResponse deleteDevice(Long deviceId);

}
