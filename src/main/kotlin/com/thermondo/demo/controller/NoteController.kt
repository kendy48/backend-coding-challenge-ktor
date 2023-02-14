package com.thermondo.demo.controller

import com.thermondo.demo.dto.NoteDto
import com.thermondo.demo.mapper.NoteMapper
import com.thermondo.demo.model.Note
import com.thermondo.demo.service.NoteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/note")
class NoteController(val noteService: NoteService) {

    //TODO: Create filter to manage Authentication

    @PostMapping
    fun addNote(@RequestBody noteDto: NoteDto,
                @RequestHeader(value="Authorization") writerId: Long) : ResponseEntity<Note> =
        ResponseEntity<Note> (
            noteService.addNote(NoteMapper.toEntity(noteDto), writerId),
            HttpStatus.CREATED
        )

    @GetMapping("/{id}")
    fun findNote(@PathVariable("id") id: Long,
                 @RequestHeader(value="Authorization") writerId: Long) : ResponseEntity<Note> =
        ResponseEntity<Note> (
            noteService.findNote(id, writerId),
            HttpStatus.OK
        )

    @GetMapping
    fun findNotes(@RequestHeader(value="Authorization") writerId: Long) : ResponseEntity<Set<Note>> =
        ResponseEntity<Set<Note>> (
            noteService.findNotes(writerId),
            HttpStatus.OK
        )

    @DeleteMapping("/{id}")
    fun deleteNote(@PathVariable("id") id: Long,
                   @RequestHeader(value="Authorization") writerId: Long) : ResponseEntity<Note> {
        noteService.deleteNote(id, writerId)
        return ResponseEntity (HttpStatus.OK)
    }


    @PutMapping("/{id}")
    fun updateNote(@PathVariable("id") id: Long,
                   @RequestBody noteDto: NoteDto,
                   @RequestHeader(value="Authorization") writerId: Long) : ResponseEntity<Note> =
        ResponseEntity<Note> (
            noteService.updateNote(NoteMapper.toEntity(id, noteDto), writerId),
            HttpStatus.OK
        )
}