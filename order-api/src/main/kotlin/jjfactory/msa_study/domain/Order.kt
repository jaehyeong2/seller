package jjfactory.msa_study.domain

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class Order(
    val userId: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    val orderProducts: MutableList<OrderProduct> = mutableListOf()

    @Enumerated(EnumType.STRING)
    var state: OrderState = OrderState.PAYMENT_WAITING

    @UpdateTimestamp
    var createdAt: LocalDateTime? = LocalDateTime.now()
    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null

    fun cancel(){
        verifyNotShipped()
        state = OrderState.CANCELED
    }

    private fun verifyNotCanceled(){
        if (isCanceled()) throw CanceledOrderException()
    }

    private fun isCanceled(): Boolean {
        return state == OrderState.CANCELED
    }

    fun markAsShipped(){
        verifyShippable()
        state = OrderState.SHIPPED
    }

    private fun verifyShippable(){
        verifyNotCanceled()
        verifyNotShipped()
    }

    private fun verifyNotShipped(){
        if (!isNotShipped()) throw AlreadyShippedException()
    }

    private fun isNotShipped(): Boolean {
        return state == OrderState.PREPARING || state == OrderState.PAYMENT_WAITING
    }
}