package jjfactory.msa_study.domain

import jjfactory.msa_study.infrastructure.SellerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class SellerReaderImpl(
    private val sellerRepository: SellerRepository
) : SellerReader {
    override fun findById(id: Long): Seller? {
        return sellerRepository.findByIdOrNull(id)
    }

    override fun findByIdOrThrow(id: Long): Seller {
        return sellerRepository.findByIdOrNull(id) ?: throw SellerNotFoundException()
    }
}