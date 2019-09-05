package ru.fmtk.khlystov.integration_hw.config

import com.github.cloudyrock.mongock.Mongock
import com.github.cloudyrock.mongock.SpringMongockBuilder
import com.mongodb.MongoClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.fmtk.khlystov.integration_hw.sevice.BookService

@Configuration
class ApplicationConfig {
    private val CHANGELOGS_PACKAGE = "ru.fmtk.khlystov.integration_hw.changelogs"

    @Bean
    fun mongock(@Value("\${spring.data.mongodb.database}") database: String,
                mongoClient: MongoClient): Mongock {
        return SpringMongockBuilder(mongoClient, database, CHANGELOGS_PACKAGE)
                .setLockQuickConfig()
                .build()
    }
}