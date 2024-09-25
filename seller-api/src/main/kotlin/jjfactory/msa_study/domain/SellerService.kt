package jjfactory.msa_study.domain

interface SellerService {
    fun store(seller: Seller): Long
    fun findById(id: Long): SellerInfo.Detail

}