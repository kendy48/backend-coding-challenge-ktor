package com.thermondo.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
class NoteControllerTest(@Autowired val mockMvc: MockMvc) {

    //TODO: create the following tests:
    // ** For create scenario **
    // Create a note successfully
    // Create a note without title or body
    // Create a note with a writer that doesn't exist

    //TODO:
    // ** get a note find{id} scenario **
    // find successfully a note
    // do request with a note a doesn't exist
    // do request with a valid note with a writer that doesn't exist
    // do request with a valid note and with a writer that is not the owner of the note


    //TODO:
    // ** get all notes find scenario **
    // find notes of a valid user
    // do request with a user that doesn't exist

    //TODO:
    // ** For delete scenario **
    // do a success delete of a note
    // do request with a user that doesn't exist
    // do request with a note that doesn't exist
    // do request with a valid note and with a writer that is not the owner of the note

    //TODO:
    // ** For update scenario **
    // do a success update of a note
    // do request with a user that doesn't exist
    // do request with a note that doesn't exist
    // do request with a valid note and with a writer that is not the owner of the note
}