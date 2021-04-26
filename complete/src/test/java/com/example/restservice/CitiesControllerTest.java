package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(classes=com.example.restservice.RestServiceApplication.class)
@AutoConfigureMockMvc
public class CitiesControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getCities() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/cities").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void getCity() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/city/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$.province", is("Coruña")));
    }
}