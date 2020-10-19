package com.philips.alerttocare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philips.alerttocare.entity.Icu;

@Repository
public interface IcuRepository extends JpaRepository<Icu, Integer>{

}
