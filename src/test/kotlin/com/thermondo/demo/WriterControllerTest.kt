package com.thermondo.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
class WriterControllerTest(@Autowired val mockMvc: MockMvc) {


    //TODO: Create tests for WriterController similar to NoteControllerTest
}