package jjfactory.msa_study.domain

interface SellerReader {
    fun findById(id: Long): Seller?
    fun findByIdOrThrow(id: Long): Seller
}