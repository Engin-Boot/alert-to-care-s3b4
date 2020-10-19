package com.philips.alerttocare.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class IcuControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetIcus() throws Exception {
		
		this.mockMvc.perform(get("/icu-mgmt/icu")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.status").value("200"))
		.andExpect(jsonPath("$.message").value("Success"))
		.andExpect(jsonPath("$.data").exists());
	}

}
