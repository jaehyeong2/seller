package jjfactory.msa_study.presentation

import jjfactory.msa_study.infrastructure.MailSender
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/notifications/seller")
@RestController
class SellerNotificationApi(
    private val mailSender: MailSender
) {


    @PostMapping("/product")
    fun sendProductAddNotification() {
        mailSender.sendProductAddNotification()
    }
}