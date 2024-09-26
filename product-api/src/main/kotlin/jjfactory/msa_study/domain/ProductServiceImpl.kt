package jjfactory.msa_study.domain

import org.springframework.stereotype.Service

@Service
class ProductServiceImpl : ProductService {
    override fun registerProduct(command: ProductCommand.Create) {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): ProductInfo.Detail {
        TODO("Not yet implemented")
    }

    override fun findListBySellerCode(sellerCode: String) {
        TODO("Not yet implemented")
    }
}