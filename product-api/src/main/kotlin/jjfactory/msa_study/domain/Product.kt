package jjfactory.msa_study.domain

import jakarta.persistence.*

@Entity
class Product(
    var name: String,
    val sellerCode: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL])
    val optionGroups: MutableList<ProductOptionGroup> = mutableListOf()

    fun addOptionGroup(optionGroup: ProductOptionGroup){
        optionGroups.add(optionGroup)
    }
}