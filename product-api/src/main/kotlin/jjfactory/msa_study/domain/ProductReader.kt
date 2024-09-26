package jjfactory.msa_study.domain

interface ProductReader {
    fun findById(id: Long): Product?
    fun findByIdOrThrow(id: Long): Product
    fun findListBySellerCode(sellerCode: String): List<Product>
}