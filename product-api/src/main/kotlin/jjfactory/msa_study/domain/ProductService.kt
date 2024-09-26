package jjfactory.msa_study.domain

interface ProductService {
    fun registerProduct(command: ProductCommand.Create)
    fun findById(id: Long): ProductInfo.Detail
    fun findListBySellerCode(sellerCode: String)
}