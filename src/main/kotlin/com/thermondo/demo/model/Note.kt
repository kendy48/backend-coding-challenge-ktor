package com.thermondo.demo.model

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table
open class Note(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Long?,

    @ManyToOne
    @JoinColumn(name="writer_id", nullable=false)
    open var writer: Writer,
    open val title: String,
    open val body: String,
    open val private: Boolean = true,
    @ElementCollection
    open val tags: MutableList<String>

    //TODO: (Optional) add createAt and updateAt properties for tracking sensitive data
) {
    constructor() : this(0, Writer(),"", "", true, mutableListOf())
}