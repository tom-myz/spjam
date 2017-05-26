package moe.awawa.spjam.web

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SpJam {
}

fun main(args: Array<String>) {
	SpringApplication.run(SpJam::class.java)
}