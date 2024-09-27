package jjfactory.msa_study.domain

class OrderCommand {
    data class Create(
        val productId: Long
    )
}