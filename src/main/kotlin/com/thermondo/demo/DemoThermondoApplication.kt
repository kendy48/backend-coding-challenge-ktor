package com.thermondo.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class DemoThermondoApplication

fun main(args: Array<String>) {
	runApplication<DemoThermondoApplication>(*args)
}
