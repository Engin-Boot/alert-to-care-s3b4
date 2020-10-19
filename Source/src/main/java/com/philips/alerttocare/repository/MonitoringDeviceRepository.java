package com.philips.alerttocare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philips.alerttocare.entity.MonitoringDevice;

@Repository
public interface MonitoringDeviceRepository extends JpaRepository<MonitoringDevice, Long> {

}
