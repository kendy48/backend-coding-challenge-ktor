package com.thermondo.demo.controller

import com.thermondo.demo.model.Note
import com.thermondo.demo.service.NoteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/p/note")
class NotePublicController(val noteService: NoteService) {

    //TODO: add tags query parameter to filter note by tags
    @GetMapping
    fun findAllNotes() : ResponseEntity<Set<Note>> =
        ResponseEntity<Set<Note>> (
            noteService.findAllNotes(),
            HttpStatus.OK
        )
}