package ru.fmtk.khlystov.integration_hw.rest

import org.springframework.messaging.support.GenericMessage
import org.springframework.messaging.support.MessageBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.fmtk.khlystov.integration_hw.config.BooksGateway
import ru.fmtk.khlystov.integration_hw.domain.Book

@RestController
class BookController(val booksGateway: BooksGateway) {

    @GetMapping("/books")
    fun getBooks(): List<Book> {
        return booksGateway.getBooks(GenericMessage(""))
    }

    @PostMapping("/books")
    fun addBook(@RequestBody(required = true) book: Book): Book {
        return booksGateway.save(MessageBuilder.withPayload(book).build())
    }
}