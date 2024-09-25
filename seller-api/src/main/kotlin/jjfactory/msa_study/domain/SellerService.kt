package jjfactory.msa_study.domain

interface SellerService {
    fun store(command: SellerCommand.Create): Long
    fun findById(id: Long): SellerInfo.Detail
}