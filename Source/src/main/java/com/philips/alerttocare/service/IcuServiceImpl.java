package com.philips.alerttocare.service;

 

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.philips.alerttocare.dto.AddIcuModel;
import com.philips.alerttocare.dto.ApiResponse;
import com.philips.alerttocare.entity.Icu;
import com.philips.alerttocare.repository.IcuRepository;
import com.philips.alerttocare.utils.AppUtils;

@Service
public class IcuServiceImpl implements IcuService {
    
    @Autowired
    private IcuRepository icuRepository;

 

    @Override
    public ApiResponse addIcu(AddIcuModel addIcuModel) {
        Icu icu=new Icu();
        if(addIcuModel.getBedLimit()<1 || addIcuModel.getBedLimit()==null)
        {
            return AppUtils.generateFailureApiResponse("Bed limit cannot be lesser than 1", 400);
        }
        icu.setLayoutInfo(addIcuModel.getLayoutInfo());
        icu.setBedLimit(addIcuModel.getBedLimit());
        icu.setTotalBeds(0);
        icu.setTimestamp(new Timestamp(System.currentTimeMillis()));
        Icu save = icuRepository.save(icu);
        return AppUtils.generateSuccessApiResponse(save);
    }

 

    @Override
    public ApiResponse getIcus() {
        return AppUtils.generateSuccessApiResponse(icuRepository.findAll());
    }

 

}