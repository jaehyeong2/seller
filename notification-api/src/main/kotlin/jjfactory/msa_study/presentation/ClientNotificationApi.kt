package jjfactory.msa_study.presentation

import jjfactory.msa_study.infrastructure.MailSender
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/notifications/client")
@RestController
class ClientNotificationApi(
    private val mailSender: MailSender
) {


    @PostMapping("/order")
    fun sendOrderSuccessNotification() {
        mailSender.sendOrderSuccessNotification()
    }
}