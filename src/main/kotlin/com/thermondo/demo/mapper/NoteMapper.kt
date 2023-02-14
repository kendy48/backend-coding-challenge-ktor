package com.thermondo.demo.mapper

import com.thermondo.demo.dto.NoteDto
import com.thermondo.demo.model.Note
import com.thermondo.demo.model.Writer

class NoteMapper {

    companion object {
        fun toEntity(noteDto: NoteDto) =
            toEntity(0, noteDto)

        fun toEntity(id: Long, noteDto: NoteDto) =
            Note(id, Writer(), noteDto.title, noteDto.body, noteDto.private, noteDto.tags)
    }
}