package in.keepgrowing.efficientmvpexample.homepage.adapters.driving.api.http.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.keepgrowing.efficientmvpexample.homepage.adapters.driving.api.http.model.HomePageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(value = HomePageController.class)
@ActiveProfiles({"dev"})
class HomePageControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private HomePageController controller;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
        assertNotNull(controller);
    }

    @Test
    void shouldGetTestData() throws Exception {
        var expected = new HomePageResponse("Home page body provided by the backend module");

        mvc.perform(get("/api/home")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expected)));
    }
}