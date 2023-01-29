package com.jjsh.takehome.controller;

import com.jjsh.takehome.TakehomeApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TakehomeApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:tests.properties")
@AutoConfigureTestDatabase
public class CalculatorControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void integrationTest() throws Exception {
        String jsonRequest = """
                {
                    "amount": 100.0,
                    "rate": 0.1,
                    "terms": 52
                }
                """;
        mvc.perform(post("/interest").contentType(MediaType.APPLICATION_JSON).content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(equalTo(52))))
                .andExpect(jsonPath("$[0].amount",  equalTo(2.115384615384616)));
    }

    @Test
    public void invalidDataTest() throws Exception {
        String jsonRequest = """
                {
                    "amount": 0.5,
                    "rate": 0.1,
                    "terms": 2
                }
                """;
        mvc.perform(post("/interest").contentType(MediaType.APPLICATION_JSON).content(jsonRequest))
                .andExpect(status().is4xxClientError());
    }
}
