package jjfactory.msa_study.infrastructure

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class MailSender {
    private val logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["order-create"], groupId = "notification-group")
    fun sendOrderSuccessNotification(){
        logger.info("order success")
    }

    @KafkaListener(topics = ["product-register"], groupId = "notification-group")
    fun sendProductRegisteredNotification(){
        logger.info("register product success")
    }
}