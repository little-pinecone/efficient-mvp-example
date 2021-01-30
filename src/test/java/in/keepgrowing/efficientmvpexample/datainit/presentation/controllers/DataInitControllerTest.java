package in.keepgrowing.efficientmvpexample.datainit.presentation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.keepgrowing.efficientmvpexample.datainit.services.DataInitializer;
import in.keepgrowing.efficientmvpexample.shared.presentation.controllers.ApiControllerPaths;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(value = DataInitController.class)
@ActiveProfiles("init")
class DataInitControllerTest {

    private static final String PATH = "/" + ApiControllerPaths.API + DataInitControllerPaths.INIT;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DataInitController controller;

    @MockBean
    private DataInitializer dataInitializer;

    @Test
    void contextLoads() {
        assertNotNull(controller);
    }

    @Test
    void shouldRunDatabaseInit() throws Exception {
        when(dataInitializer.init(123L, 10))
                .thenReturn(123L);

        var expectedResponse = objectMapper.writeValueAsString(123L);

        mvc.perform(get(PATH + "?seed=123&how-many-books=10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
    }
}