package com.philips.alerttocare.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.philips.alerttocare.constants.BedStatus;
import com.philips.alerttocare.dto.AddBedModel;
import com.philips.alerttocare.dto.ApiResponse;
import com.philips.alerttocare.entity.Bed;
import com.philips.alerttocare.entity.Icu;
import com.philips.alerttocare.repository.BedRepository;
import com.philips.alerttocare.repository.IcuRepository;
import com.philips.alerttocare.utils.AppUtils;



@Service
@Transactional
public class BedServiceImpl implements BedService{
	
	@Autowired
	private BedRepository bedRepository;
	
	@Autowired
	private IcuRepository icuRepository;
	
	@Override
	public ApiResponse saveBed(AddBedModel addBedModel) {
		
		ApiResponse response = null;
		Optional<Icu> optional = icuRepository.findById(addBedModel.getIcuId());
		if(optional.isPresent()) {
			Icu icu = optional.get();
			Bed bed=new Bed();
			bed.setBedStatus(BedStatus.VACANT);
			icu.setIcuId(addBedModel.getIcuId());
			Integer totalBeds = icu.getTotalBeds();
			if(totalBeds<icu.getBedLimit()) {
				icu.setTotalBeds(icu.getTotalBeds()+1);
				bed.setIcu(icu);
				bed.setTimestamp(new Timestamp(System.currentTimeMillis()));
				Bed savedBed = bedRepository.save(bed);
				response = AppUtils.generateSuccessApiResponse(savedBed);
			}else {
				response = AppUtils.generateFailureApiResponse("Max Bed Limit Reached", 404);
			}
		}else {
			response = AppUtils.generateFailureApiResponse("Invalid Icu ID", 404);
		}
		return response;
	}

	@Override
	public ApiResponse getAllBeds() {
		
		List<Bed> bed =  bedRepository.findAll();
		return AppUtils.generateSuccessApiResponse(bed);
	}

	@Override
	public ApiResponse getBedbyId(Integer id) {
		Optional<Bed> bedDb = this.bedRepository.findById(id);
		if(bedDb.isPresent()) {
			Bed bed = bedDb.get();
			return AppUtils.generateSuccessApiResponse(bed);
		}
		else {
			return AppUtils.generateFailureApiResponse("Invalid bed Id", 400);
		}
		
	}

	@Override
	public ApiResponse deleteBed(Integer id) {
		Optional<Bed> bedDb = this.bedRepository.findById(id);
		if(bedDb.isPresent()) {
			Bed bed = bedDb.get();
			this.bedRepository.delete(bedDb.get());
			return AppUtils.generateSuccessApiResponse(bed);
		}
		else {
			return AppUtils.generateFailureApiResponse("Invalid bed Id", 400);
		}
		
	}

}
