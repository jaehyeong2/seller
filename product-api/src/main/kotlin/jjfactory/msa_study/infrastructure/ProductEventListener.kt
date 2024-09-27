package jjfactory.msa_study.infrastructure

import jjfactory.msa_study.domain.ProductEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class ProductEventListener(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

//    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
//    fun beforeCommit() {
//
//    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun publishEventToKafka(event: ProductEvent.Create) {
        kafkaTemplate.send("product-register", event.toString())
    }
}