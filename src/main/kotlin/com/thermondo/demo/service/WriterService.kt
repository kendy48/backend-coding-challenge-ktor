package com.thermondo.demo.service

import com.thermondo.demo.model.Writer
import com.thermondo.demo.repository.WriterRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class WriterService(val writerRepository: WriterRepository) {

    fun addWriter(writer: Writer) : Writer  =
        writerRepository.save(writer)

    fun findWriter(id: Long) : Writer =
        writerRepository.findById(id).orElseThrow { WriterNotFoundException(id) }

    fun deleteWriter(id: Long) {
        val writer = writerRepository.findById(id).orElseThrow { WriterNotFoundException(id) }
        writerRepository.delete(writer)
    }

    class WriterNotFoundException(id: Long) :
        ResponseStatusException(HttpStatus.NOT_FOUND, "Writer '$id' not found")
}