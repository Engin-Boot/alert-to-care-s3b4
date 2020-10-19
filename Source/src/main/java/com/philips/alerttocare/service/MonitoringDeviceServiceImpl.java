package com.philips.alerttocare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.philips.alerttocare.dto.ApiResponse;
import com.philips.alerttocare.entity.MonitoringDevice;
import com.philips.alerttocare.repository.MonitoringDeviceRepository;
import com.philips.alerttocare.utils.AppUtils;



@Service
@Transactional
public class MonitoringDeviceServiceImpl implements MonitoringDeviceService {

	@Autowired
	MonitoringDeviceRepository deviceRepository;

	@Override
	public ApiResponse addDevice(MonitoringDevice monitoringDevice) {
		MonitoringDevice savedDevice = deviceRepository.save(monitoringDevice);
		return AppUtils.generateSuccessApiResponse(savedDevice);
	}

	@Override
	public ApiResponse getAllDevice() {
		return AppUtils.generateSuccessApiResponse(this.deviceRepository.findAll());
	}

	@Override
	public ApiResponse getDeviceById(Long deviceId) {
		Optional<MonitoringDevice> deviceDb = this.deviceRepository.findById(deviceId);
		if (deviceDb.isPresent()) {
			MonitoringDevice monitoringDevice = deviceDb.get();
			return AppUtils.generateSuccessApiResponse(monitoringDevice);
		} else {
			return AppUtils.generateFailureApiResponse("Device Not found", 404);
		}
	}

	@Override
	public ApiResponse deleteDevice(Long deviceId) {
		Optional<MonitoringDevice> deviceDb = this.deviceRepository.findById(deviceId);
		if (deviceDb.isPresent()) {
			MonitoringDevice monitoringDevice = deviceDb.get();
			this.deviceRepository.delete(monitoringDevice);
			return AppUtils.generateSuccessApiResponse(monitoringDevice);
		} else {
			return AppUtils.generateFailureApiResponse("Device Not found", 404);
		}
	}

	@Override
	public ApiResponse updateDevice(Long deviceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
