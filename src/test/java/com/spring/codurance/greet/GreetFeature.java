package com.spring.codurance.greet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetFeature {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TimeService timeService;

	@Test
	public void should_greet() throws Exception {
		given(timeService.getTime()).willReturn(new Clock(11));

		mockMvc.perform(get("/greet?name=Damián"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.salutation", is("Hello Damián, good morning!")));
	}

	@Test
	public void should_greet_stranger() throws Exception {
		given(timeService.getTime()).willReturn(new Clock(12));

		mockMvc.perform(get("/greet"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.salutation", is("Hello Strangers, good afternoon!")));
	}
}
