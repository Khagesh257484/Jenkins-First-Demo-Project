package com.company.jenkinsdemoproject.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Positive Test Case: /greeting/{name} with a valid name
    @Test
    public void greeting_with_name_should_return_personalized_message() throws Exception {
        String name = "Khagesh Sharma";

        mockMvc.perform(MockMvcRequestBuilders.get("/greeting/{name}", name))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello " + name + ", Congratulations, Welcome in your Jenkins-Demo endpoint"));
    }

    // Positive Test Case: /greeting without name (default Guest)
    @Test
    public void greeting_without_name_should_return_default_message() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello Guest, Congratulations, Welcome in your Jenkins-Demo endpoint"));
    }

    // Negative Test Case: unsupported HTTP method (POST)
    @Test
    public void greeting_with_post_should_return_method_not_allowed() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/greeting"))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }

    // Negative Test Case: invalid path
    @Test
    public void invalid_path_should_return_404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/invalid-path"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    // Exception Test Case: simulate exception handling (NullPointerException)
    @Test
    @Disabled
    public void greeting_should_handle_exception() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}