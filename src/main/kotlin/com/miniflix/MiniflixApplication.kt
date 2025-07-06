package com.miniflix

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MiniflixApplication

fun main(args: Array<String>) {
	runApplication<MiniflixApplication>(*args)
}
