package ru.fmtk.khlystov.integration_hw.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.IntegrationComponentScan
import org.springframework.integration.dsl.IntegrationFlow
import org.springframework.integration.dsl.IntegrationFlows
import org.springframework.integration.dsl.MessageChannels
import org.springframework.messaging.MessageChannel

@Configuration
@IntegrationComponentScan
class IntegrationConfig {

    @Bean
    fun getBooksRequestChannel(): MessageChannel = MessageChannels.publishSubscribe().get()

    @Bean
    fun getBooksReplayChannel(): MessageChannel = MessageChannels.publishSubscribe().get()

    @Bean
    fun getBooksFlow(): IntegrationFlow = IntegrationFlows
            .from("getBooksRequestChannel")
            .handle("bookService", "getBooks")
            .channel("getBooksReplayChannel")
            .get()

    @Bean
    fun saveBookRequestChannel(): MessageChannel = MessageChannels.publishSubscribe().get()

    @Bean
    fun saveBookReplyChannel(): MessageChannel = MessageChannels.publishSubscribe().get()

    @Bean
    fun saveBookFlow(): IntegrationFlow = IntegrationFlows
            .from("saveBookRequestChannel")
            .handle("bookService", "saveBook")
            .channel("saveBookReplyChannel")
            .get()

}