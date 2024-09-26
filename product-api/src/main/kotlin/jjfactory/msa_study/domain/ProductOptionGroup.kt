package jjfactory.msa_study.domain

import jakarta.persistence.*

@Entity
class ProductOptionGroup(
    @ManyToOne(fetch = FetchType.LAZY)
    var product: Product,
    var name: String
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}