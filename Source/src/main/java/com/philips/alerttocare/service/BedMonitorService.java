package com.philips.alerttocare.service;

import com.philips.alerttocare.dto.ApiResponse;
import com.philips.alerttocare.entity.BedMonitor;

public interface BedMonitorService {

	ApiResponse mapBedDevice(BedMonitor bedMonitor);
	ApiResponse getAllBedMonitors();
	ApiResponse updateBedDevice(BedMonitor bedMonitor);

	
}
