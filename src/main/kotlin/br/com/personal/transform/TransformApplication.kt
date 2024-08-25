package br.com.personal.transform

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TransformApplication

fun main(args: Array<String>) {
	runApplication<TransformApplication>(*args)
}
