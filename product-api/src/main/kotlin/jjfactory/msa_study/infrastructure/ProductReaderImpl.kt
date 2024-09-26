package jjfactory.msa_study.infrastructure

import jjfactory.msa_study.domain.Product
import jjfactory.msa_study.domain.ProductNotFoundException
import jjfactory.msa_study.domain.ProductReader
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ProductReaderImpl(
    private val productRepository: ProductRepository
) : ProductReader {
    override fun findById(id: Long): Product? {
        return productRepository.findByIdOrNull(id)
    }

    override fun findByIdOrThrow(id: Long): Product {
        return productRepository.findByIdOrNull(id) ?: throw ProductNotFoundException()
    }

    override fun findListBySellerCode(sellerCode: String): List<Product> {
        return productRepository.findAllBySellerCode(sellerCode)
    }
}