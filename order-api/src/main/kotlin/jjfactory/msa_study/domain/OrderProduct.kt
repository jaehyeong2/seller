package jjfactory.msa_study.domain

import jakarta.persistence.*

@Entity
class OrderProduct(
    @ManyToOne(fetch = FetchType.LAZY)
    val order: Order,
    val productId: Long,
    val cnt: Int = 1
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}