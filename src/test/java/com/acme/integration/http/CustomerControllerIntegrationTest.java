package com.acme.integration.http;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void postCustomer_succeeds() throws Exception {
        mvc.perform(post("/customers")
                .content("{\"name\":\"ComputerArtists Inc\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(header().string("Location", "customers/1"));

        mvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(content().json("{\"name\":\"ComputerArtists Inc\"}"));
    }

    @Test
    void getCustomerById_succeeds() throws Exception {
        mvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(content().json("{\"name\":\"ComputerArtists Inc\"}"));
    }


    @Test
    void getCustomers_succeeds() throws Exception {
        mvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(content().json("[]"));
    }

    @Test
    void putCustomer_succeeds() throws Exception {
        mvc.perform(put("/customers/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"name\":\"ComputerArtists Inc.\"}"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(content().json("{\"name\":\"ComputerArtists Inc.\"}"));
    }

    @Test
    void deleteCustomer_succeeds() throws Exception {
        mvc.perform(delete("/customers/1"))
                .andExpect(status().isOk());

    }
}
