package jjfactory.msa_study.domain

class ProductEvent {
    data class Create(
        val id: Long,
        val name: String
    )
}