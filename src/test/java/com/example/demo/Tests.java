package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class Tests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test1() throws Exception {
		this.mockMvc.perform(get("/inc/str?str=80 80 80")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("81 81 81")));
	}

	@Test
	public void test2() throws Exception {
		this.mockMvc.perform(get("/inc/str?str=12 21 32")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("13 22 33")));
	}

}
