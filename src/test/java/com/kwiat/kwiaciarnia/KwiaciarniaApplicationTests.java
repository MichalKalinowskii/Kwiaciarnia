package com.kwiat.kwiaciarnia;

import com.kwiat.kwiaciarnia.Controllers.ColourController;
import com.kwiat.kwiaciarnia.Controllers.FlowerControler;
import com.kwiat.kwiaciarnia.Models.Colour;
import com.kwiat.kwiaciarnia.Models.Flower;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK,
		classes = Colour.class)
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:src/main/resources/application-integrationtest.properties.properties")
class KwiaciarniaApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ColourController colourController;

	@Test
	public void shouldReturnCreatedStatus() throws Exception {
		mvc.perform(post("/colour/create/Cynkowy")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	private void createTestColour(String name) {
		colourController.createColour(name);
	}
}
