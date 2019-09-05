package ru.fmtk.khlystov.integration_hw.config

import org.springframework.integration.annotation.Gateway
import org.springframework.integration.annotation.MessagingGateway
import org.springframework.messaging.Message
import ru.fmtk.khlystov.integration_hw.domain.Book

@MessagingGateway
interface BooksGateway {
    @Gateway(requestChannel = "getBooksRequestChannel", replyChannel = "getBooksReplayChannel")
    fun getBooks(message: Message<*>): List<Book>

    @Gateway(requestChannel = "saveBookRequestChannel", replyChannel = "saveBookReplyChannel")
    fun save(message: Message<Book>): Book
}