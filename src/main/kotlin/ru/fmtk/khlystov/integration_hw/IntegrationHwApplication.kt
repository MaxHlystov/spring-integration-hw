package ru.fmtk.khlystov.integration_hw

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories("ru.fmtk.khlystov.integration_hw.repository")
class IntegrationHwApplication

fun main(args: Array<String>) {
    runApplication<IntegrationHwApplication>(*args)
}
