package com.philips.alerttocare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.philips.alerttocare.dto.ApiResponse;
import com.philips.alerttocare.entity.Bed;
import com.philips.alerttocare.entity.BedMonitor;

import com.philips.alerttocare.repository.BedMonitorRepository;
import com.philips.alerttocare.repository.BedRepository;
import com.philips.alerttocare.utils.AppUtils;


@Service
@Transactional
public class BedMonitorServiceImpl implements BedMonitorService {

	@Autowired
	BedRepository bedRepository;
	@Autowired
	BedMonitorRepository bedMonitorRepository;

	@Override
	public ApiResponse mapBedDevice(BedMonitor bedMonitor) {

		Optional<Bed> optional = bedRepository.findById(bedMonitor.getBedId());

		if (optional.isPresent()) {
			bedMonitor.setStatus("OFF");
			bedMonitor.setSpo2(0);
			bedMonitor.setRespirationRate(0);
			bedMonitor.setBodyTemperature(0);
			BedMonitor savedBedMonitor = bedMonitorRepository.save(bedMonitor);
			return AppUtils.generateSuccessApiResponse(savedBedMonitor);

		} else {
			return AppUtils.generateFailureApiResponse("Bed Does not exist", 400);
		}
	}

	@Override
	public ApiResponse getAllBedMonitors() {
		List<BedMonitor> bedMonitor = bedMonitorRepository.findAll();
		return AppUtils.generateSuccessApiResponse(bedMonitor);
	}

	@Override
	public ApiResponse updateBedDevice(BedMonitor bedMonitor) {
		Optional<BedMonitor> optional = bedMonitorRepository.findByDeviceID(bedMonitor.getDeviceID());
		if (optional.isPresent()) {
			BedMonitor bedMon = optional.get();
			bedMon.setStatus(bedMonitor.getStatus());
			bedMon.setSpo2(bedMonitor.getSpo2());
			bedMon.setRespirationRate(bedMonitor.getRespirationRate());
			bedMon.setBodyTemperature(bedMonitor.getBodyTemperature());
			bedMon.setMessage(checkVitals(bedMonitor.getSpo2(),bedMonitor.getRespirationRate(),bedMonitor.getBodyTemperature()));
			BedMonitor savedBedMonitor = bedMonitorRepository.save(bedMon);
			return AppUtils.generateSuccessApiResponse(savedBedMonitor);

		} else {
			return AppUtils.generateFailureApiResponse("BedMonitor Does not exist", 400);
		}
	}


	
	private String checkVitals(Integer spo2, Integer respirationRate, Integer bodyTemperature) {
		String message = null;
		message = "SPO2 :" + checkSpo2(spo2);
		message+= ", Body Temp : " + checkBodyTemp(bodyTemperature);
		message+= ", Respiratory Rate : " + checkRespiratoryRate(respirationRate);
		return message;
	}

	public String checkSpo2(int Spo2) {
		if(Spo2<90)
		{
			return "less than 90%";
		}
		else return "normal";
	}
	
	public String checkBodyTemp(int temp) {
		if(temp>99)
		{
			return "greater than 99 F";
		}
		else return "normal";
	}
	
	public String checkRespiratoryRate(int respiratoryRate) {
		if(respiratoryRate>16 || respiratoryRate <12)
		{
			return "Respiratory Rate not in range (12-16)";
		}
		else return "normal";
	}
}

		



