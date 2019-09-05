package ru.fmtk.khlystov.integration_hw.repository

import org.springframework.data.mongodb.repository.MongoRepository
import ru.fmtk.khlystov.integration_hw.domain.Book


interface BookRepository: MongoRepository<Book, String>