package jjfactory.msa_study.domain

import jjfactory.msa_study.infrastructure.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val productReader: ProductReader
) : ProductService {

    @Transactional
    override fun registerProduct(command: ProductCommand.Create): Long {
        val initProduct = command.toEntity()

        command.groups.forEach {
            val initGroup = ProductOptionGroup(
                product = initProduct,
                name = it.name
            )

            initProduct.addOptionGroup(initGroup)

            it.options.forEach { option ->
                val initOption = ProductOption(
                    optionGroup = initGroup,
                    name = option.name
                )

                initGroup.addOption(initOption)
            }
        }

        return productRepository.save(initProduct).id!!
    }

    override fun findById(id: Long): ProductInfo.Detail {
        return productReader.findByIdOrThrow(id).let {
            ProductInfo.Detail(
                name = it.name,
                sellerCode = it.sellerCode,
                groups = it.optionGroups.map { og ->
                    ProductOptionGroupInfo.Detail(
                        name = og.name,
                        options = og.options.map { o ->
                            ProductOptionInfo.Detail(
                                name = o.name
                            )
                        }
                    )
                }
            )
        }
    }

    override fun findListBySellerCode(sellerCode: String) {
        TODO("Not yet implemented")
    }
}