package com.protoseo.hellodatabase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloDatabaseApplication

fun main(args: Array<String>) {
    runApplication<HelloDatabaseApplication>(*args)
}
