package ru.fmtk.khlystov.integration_hw.changelogs

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.fmtk.khlystov.integration_hw.domain.Book

@ChangeLog(order = "001")
class InitMongoDBChangelog {
    @ChangeSet(order = "001", id = "initBooks", author = "Khlystov")
    fun initBooks(template: MongoTemplate) {
        template.insertAll(listOf<Book>(
                Book(null, "Book 1", "Author 1", "Description 1"),
                Book(null, "Book 2", "Author 1", "Description 2"),
                Book(null, "Book 3", "Author 2", "Description 3")
        ))
    }
}