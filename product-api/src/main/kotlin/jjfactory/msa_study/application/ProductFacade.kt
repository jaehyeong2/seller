package jjfactory.msa_study.application

import jjfactory.msa_study.domain.ProductCommand
import jjfactory.msa_study.domain.ProductEvent
import jjfactory.msa_study.domain.ProductService
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class ProductFacade(
    private val productService: ProductService,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun registerProduct(command: ProductCommand.Create){
        val productInfo = productService.registerProduct(command)
        applicationEventPublisher.publishEvent(ProductEvent.Create(id = productInfo.id, name = productInfo.name))
    }
}