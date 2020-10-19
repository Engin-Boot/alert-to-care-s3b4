package com.philips.alerttocare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.philips.alerttocare.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{


}
