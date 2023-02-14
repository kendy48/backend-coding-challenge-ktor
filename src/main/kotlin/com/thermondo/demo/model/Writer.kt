package com.thermondo.demo.model

import javax.persistence.*

@Entity
@Table
open class Writer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Long?,
    open val name: String,
    @OneToMany(fetch = FetchType.LAZY)
    open val notes: MutableSet<Note>

    //TODO: (Optional) add createdBy, createAt and updateAt properties for tracking sensitive data
) {
    constructor() : this(0, "", mutableSetOf())
}