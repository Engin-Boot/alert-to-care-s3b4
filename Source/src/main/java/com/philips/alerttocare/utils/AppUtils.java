package com.philips.alerttocare.utils;

import com.philips.alerttocare.dto.ApiResponse;

public class AppUtils {
	
	public static ApiResponse generateSuccessApiResponse(Object data) {
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setMessage("Success");
		apiResponse.setData(data);
		apiResponse.setStatus(200);
		return apiResponse;
	}
	
	public static ApiResponse generateFailureApiResponse(String message, Integer statusCode) {
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setMessage(message);
		apiResponse.setStatus(statusCode);
		return apiResponse;
	}
}
