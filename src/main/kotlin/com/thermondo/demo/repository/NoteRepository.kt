package com.thermondo.demo.repository

import com.thermondo.demo.model.Note
import com.thermondo.demo.model.Writer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : JpaRepository<Note, Long> {
    fun findByWriter(writer: Writer) : Set<Note>

    fun findByPrivate(private: Boolean) : Set<Note>
}