package in.keepgrowing.efficientmvpexample.books.adapters.driving.api.http.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.keepgrowing.efficientmvpexample.books.adapters.driving.api.http.model.responses.BookDtoMapper;
import in.keepgrowing.efficientmvpexample.books.adapters.driving.api.http.model.responses.BookResponse;
import in.keepgrowing.efficientmvpexample.books.domain.model.Book;
import in.keepgrowing.efficientmvpexample.books.domain.persistence.BookRepository;
import in.keepgrowing.efficientmvpexample.shared.config.MvcConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(value = BookController.class)
class BookControllerTest {

    private static final String PATH = "/" + MvcConfig.API_PREFIX + "/" + BookControllerPaths.BOOKS;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BookController controller;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private BookDtoMapper bookDtoMapper;

    @Test
    void contextLoads() {
        assertNotNull(controller);
    }

    @Test
    @WithMockUser
    void shouldGetBook() throws Exception {
        var book = mock(Book.class);
        when(bookRepository.findById(1L))
                .thenReturn(Optional.of(book));

        var bookDto = new BookResponse();
        when(bookDtoMapper.toDto(book))
                .thenReturn(bookDto);

        var expectedResponse = objectMapper.writeValueAsString(bookDto);

        mvc.perform(get(PATH + "/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
    }

    @Test
    @WithMockUser
    void shouldReturnStatusNotFound() throws Exception {
        when(bookRepository.findById(1L))
                .thenReturn(Optional.empty());

        mvc.perform(get(PATH + "/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}