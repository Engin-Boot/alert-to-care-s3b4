package com.philips.alerttocare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.philips.alerttocare.constants.BedStatus;
import com.philips.alerttocare.dto.ApiResponse;
import com.philips.alerttocare.entity.Bed;
import com.philips.alerttocare.entity.BedMonitor;
import com.philips.alerttocare.entity.Patient;
import com.philips.alerttocare.repository.BedMonitorRepository;
import com.philips.alerttocare.repository.BedRepository;
import com.philips.alerttocare.repository.PatientRepository;
import com.philips.alerttocare.utils.AppUtils;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private BedRepository bedRepository;

	@Autowired
	private BedMonitorRepository bedMonitorRepository;

	@Override
	public ApiResponse createPatient(Patient patient) {

		Optional<Bed> optional = bedRepository.findById((int) patient.getBedId());
		Optional<BedMonitor> optional1 = bedMonitorRepository.findBybedId((int) patient.getBedId());
		
		if (optional.isPresent() && optional1.isPresent()) {
			BedMonitor bedMonitor = optional1.get();
			bedMonitor.setStatus("ON");
			Bed bed = optional.get();
			bed.setBedStatus(BedStatus.OCCUPIED);
			Patient savedPatient = patientRepo.save(patient);
			return AppUtils.generateSuccessApiResponse(savedPatient);
		} else {
			return AppUtils.generateFailureApiResponse("Invalid Bed ID or Monitor ID", 400);
		}
	}

	@Override
	public ApiResponse updatePatient(Patient patient) {
		Optional<Patient> patientDb = this.patientRepo.findById(patient.getPid());

		if (patientDb.isPresent()) {
			Patient patientUpdate = patientDb.get();
			patientUpdate.setPid(patient.getPid());
			patientUpdate.setName(patient.getName());
			patientUpdate.setEmail(patient.getEmail());
			patientRepo.save(patientUpdate);
			return AppUtils.generateSuccessApiResponse(patientUpdate);
		} else {
			return AppUtils.generateFailureApiResponse("Patient Not found", 404);
		}

	}

	@Override
	public ApiResponse getAllPatients() {
		return AppUtils.generateSuccessApiResponse(this.patientRepo.findAll());
	}

	@Override
	public ApiResponse getPatientbyId(long patientId) {
		Optional<Patient> patientDb = this.patientRepo.findById(patientId);
		if (patientDb.isPresent()) {
			Patient patient = patientDb.get();
			return AppUtils.generateSuccessApiResponse(patient);
		} else {
			return AppUtils.generateFailureApiResponse("Patient Not found", 404);
		}
	}

	@Override
	public ApiResponse deletePatient(long id) {
		Optional<Patient> patientDb = this.patientRepo.findById(id);
		if (patientDb.isPresent()) {
			Patient patient = patientDb.get();
			Optional<BedMonitor> optional1 = bedMonitorRepository.findBybedId((int) patient.getBedId());
			Optional<Bed> bedDb = bedRepository.findById((int) patient.getBedId());
			Bed bed = bedDb.get();
			bed.setBedStatus(BedStatus.VACANT);
			BedMonitor bedMonitor = optional1.get();
			bedMonitor.setStatus("OFF");
			bedMonitor.setRespirationRate(0);
			bedMonitor.setSpo2(0);
			bedMonitor.setBodyTemperature(0);
			this.patientRepo.delete(patient);
			return AppUtils.generateSuccessApiResponse(patient);
		} else {
			return AppUtils.generateFailureApiResponse("Patient Not found", 404);
		}
	}

}
