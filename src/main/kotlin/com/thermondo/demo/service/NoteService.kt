package com.thermondo.demo.service

import com.thermondo.demo.model.Note
import com.thermondo.demo.repository.NoteRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class NoteService(val noteRepository: NoteRepository, val writerService: WriterService) {

    fun addNote(note: Note, writerId: Long) : Note  {
        val writer = writerService.findWriter(writerId)
        note.writer = writer
        return noteRepository.save(note)
    }

    fun updateNote(note: Note, writerId: Long) : Note  {
        val noteId = note.id ?: 0
        val writer = writerService.findWriter(writerId)

        val savedNote = noteRepository.findById(noteId)
            .orElseThrow { NoteNotFoundException(noteId) }
        if(savedNote.writer.id != writerId)
            throw NotedUnauthorizedException(noteId)

        note.writer = writer
        return noteRepository.save(note)
    }


    fun findNote(id: Long, writerId: Long) : Note {
        val note = noteRepository.findById(id).orElseThrow { NoteNotFoundException(id) }
        if(note.writer.id !=  writerId)
            throw NotedUnauthorizedException(writerId)
        return note
    }


    fun findNotes(writerId: Long) : Set<Note> {
        val writer = writerService.findWriter(writerId)
        return noteRepository.findByWriter(writer)
    }


    //TODO: add tags parameter to filter notes by tags
    fun findAllNotes() : Set<Note>  =
        noteRepository.findByPrivate(false)



    fun deleteNote(id: Long, writerId: Long) {
        val note = noteRepository.findById(id).orElseThrow { NoteNotFoundException(id) }
        if(note.writer.id !=  writerId)
            throw NotedUnauthorizedException(writerId)
        noteRepository.delete(note);
    }


    class NoteNotFoundException(id: Long) :
        ResponseStatusException(HttpStatus.NOT_FOUND, "Note '$id' not found")

    class NotedUnauthorizedException(id: Long) :
        ResponseStatusException(HttpStatus.UNAUTHORIZED, "you are not authorized to work with note '$id'")
}