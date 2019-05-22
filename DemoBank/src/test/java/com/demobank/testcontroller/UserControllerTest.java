package com.demobank.testcontroller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.DemoBankApplication;
import com.main.controller.UserController;
import com.main.model.User;
import com.main.repository.TransactionRepoIntf;
import com.main.repository.UserRepositoryIntf;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = DemoBankApplication.class)
public class UserControllerTest {

	
	private MockMvc mvc;
	
	@MockBean
	UserRepositoryIntf userRepo;
	
	@MockBean
	TransactionRepoIntf transRepo;
	
	@Test
	public void saveUser() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.post("/save")
				.content(asJsonString(new User(1,"logeshwar","sekar","logesh","pass","logesh@xyz.com",10000.0)))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}

	private String asJsonString(User user) {
		
		try {
			return new ObjectMapper().writeValueAsString(user);
		} catch (Exception e) {
			
			 throw new RuntimeException(e);
		}
	}	
}