package jjfactory.msa_study.domain

import jakarta.persistence.*

@Entity
class ProductOption(
    @ManyToOne(fetch = FetchType.LAZY)
    var optionGroup: ProductOptionGroup,
    var name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}