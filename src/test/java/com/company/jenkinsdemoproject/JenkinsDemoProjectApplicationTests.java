package com.company.jenkinsdemoproject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest
class JenkinsDemoProjectApplicationTests {

    @Autowired
    private MockMvc mock;


    @Test
    @DisplayName("GreetingEndpoint")
    public void greeting_endpoint_test() throws Exception {
        String name = "Khagesh Sharma";
        mock.perform(MockMvcRequestBuilders.get("/greetings/{name}", name))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello " + name + ", Congratulations, Welcome in your Jenkins-Demo endpoint"));

    }

    @Test
    @DisplayName("HelloEndpoint")
    public void hello_endpoint_test_without_passingName_in_test_method() throws Exception {
        // When no name is passed, the default "Guest" should be used
        mock.perform(MockMvcRequestBuilders.get("/greetings"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello Guest, Congratulations, Welcome in your Jenkins-Hello endpoint"));
    }

}
