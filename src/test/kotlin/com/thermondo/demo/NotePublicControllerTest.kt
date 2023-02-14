package com.thermondo.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
class NotePublicControllerTest(@Autowired val mockMvc: MockMvc) {

    //TODO: create the following tests:
    // ** For findAllNotes scenario **
    // Create a list with only public notes, response should match the list
    // Create a list with only public notes,
    //      and do request with tags response should match the list with the same tags
    // Create a list with only private notes, response should be empty
    // Create a list with private and public notes, response should contain only public notes
    // Create a list with private and public notes,
    //      and do request with tags response should match the public notes with the same tags
}