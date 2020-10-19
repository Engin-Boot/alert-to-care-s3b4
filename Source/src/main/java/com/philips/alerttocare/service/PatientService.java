package com.philips.alerttocare.service;



import com.philips.alerttocare.dto.ApiResponse;
import com.philips.alerttocare.entity.Patient;



public interface PatientService {
	
	ApiResponse createPatient(Patient patient);
	ApiResponse updatePatient(Patient patient);
	ApiResponse getAllPatients();
	ApiResponse getPatientbyId(long patientId);
	ApiResponse deletePatient(long id);
}
