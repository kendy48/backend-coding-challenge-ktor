package com.thermondo.demo.repository

import com.thermondo.demo.model.Writer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WriterRepository : JpaRepository<Writer, Long>