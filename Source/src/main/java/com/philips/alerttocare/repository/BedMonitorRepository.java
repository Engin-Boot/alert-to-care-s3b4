package com.philips.alerttocare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philips.alerttocare.entity.Bed;
import com.philips.alerttocare.entity.BedMonitor;

@Repository
public interface BedMonitorRepository extends JpaRepository<BedMonitor, Long> {

	Optional<BedMonitor> findBybedId(int bedId);

	Optional<BedMonitor> findByDeviceID(long deviceID);
	
	
}
