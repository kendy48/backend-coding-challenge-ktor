package com.thermondo.demo.mapper

import com.thermondo.demo.dto.WriterDto
import com.thermondo.demo.model.Writer

class WriterMapper {

    companion object {
        fun toEntity(writerDto: WriterDto) =
            Writer(0, writerDto.name, mutableSetOf())
    }
}