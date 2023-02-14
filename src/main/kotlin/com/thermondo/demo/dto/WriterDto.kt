package com.thermondo.demo.dto

class WriterDto(
    val id: Long,
    val name: String
) {
    init {
        require(name.isNotBlank()) { "name cant be blank" }
    }
}