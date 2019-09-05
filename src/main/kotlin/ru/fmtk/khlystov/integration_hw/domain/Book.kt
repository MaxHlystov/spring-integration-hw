package ru.fmtk.khlystov.integration_hw.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "books")
data class Book(@Id val id: String?,
                val title: String,
                val author: String,
                val description: String)