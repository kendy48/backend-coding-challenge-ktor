package com.thermondo.demo.controller

import com.thermondo.demo.dto.WriterDto
import com.thermondo.demo.mapper.WriterMapper
import com.thermondo.demo.model.Writer
import com.thermondo.demo.service.WriterService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/writer")
class WriterController(val writerService: WriterService) {

    @PostMapping
    fun addNote(@RequestBody writerDto: WriterDto) : ResponseEntity<Writer> =
        ResponseEntity<Writer> (
            writerService.addWriter(WriterMapper.toEntity(writerDto)),
            HttpStatus.CREATED
        )

    @GetMapping("/{id}")
    fun findWriter(@PathVariable("id") id: Long) : ResponseEntity<Writer> =
        ResponseEntity<Writer> (
            writerService.findWriter(id),
            HttpStatus.OK
        )

    @DeleteMapping("/{id}")
    fun deleteWriter(@PathVariable("id") id: Long) : ResponseEntity<Writer> {
        writerService.deleteWriter(id)
        return ResponseEntity<Writer> (
            HttpStatus.OK
        )
    }
}