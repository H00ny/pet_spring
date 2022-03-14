package com.example.bookshop.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.bookshop.controller.rest.BookRestController;
import com.example.bookshop.dto.BookDto;
import com.example.bookshop.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = BookRestController.class)
@ExtendWith(MockitoExtension.class)
@TestPropertySource(
        locations = "classpath:application-test.properties",
        properties = "application-test.properties")
class BookControllerTest {
    private static ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;

    @BeforeAll
    private static void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @Test
    void getAllEventConfigsShouldBeOk() throws Exception {
        String path = "/rest/book";
        List<BookDto> bookDtoList = new ArrayList<>();
        when(bookService.findAll()).thenReturn(bookDtoList);
        this.mockMvc.perform(get(path)).andExpect(status().isOk()).andReturn();
    }
}