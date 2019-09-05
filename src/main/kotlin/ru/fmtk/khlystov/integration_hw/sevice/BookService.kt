package ru.fmtk.khlystov.integration_hw.sevice

import org.springframework.stereotype.Service
import ru.fmtk.khlystov.integration_hw.domain.Book
import ru.fmtk.khlystov.integration_hw.repository.BookRepository

@Service
class BookService(val bookRepository: BookRepository) {
    fun getBooks(): List<Book> = bookRepository.findAll()

    fun saveBook(book: Book): Book = bookRepository.save(book)
}