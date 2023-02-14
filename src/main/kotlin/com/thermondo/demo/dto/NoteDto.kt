package com.thermondo.demo.dto

class NoteDto(
    val title: String,
    val body: String,
    val private: Boolean,
    val tags: MutableList<String>
) {
    init {
        require(title.isNotBlank()) { "title cant be blank" }
        require(body.isNotBlank()) { "body cant be blank" }
    }
}