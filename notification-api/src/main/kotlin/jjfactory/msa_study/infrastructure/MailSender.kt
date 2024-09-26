package jjfactory.msa_study.infrastructure

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class MailSender {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun sendOrderSuccessNotification(){
        logger.info("order success")
    }

    fun sendProductAddNotification(){
        logger.info("register product success")
    }
}