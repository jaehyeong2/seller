package jjfactory.msa_study.presentation

import jjfactory.msa_study.CommonResponse
import jjfactory.msa_study.LimitRequestPerTime
import jjfactory.msa_study.application.ProductFacade
import jjfactory.msa_study.domain.ProductCommand
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit

@RequestMapping("/products")
@RestController
class ProductApi(
    private val productFacade: ProductFacade
) {

    @PostMapping
    fun registerProducts(@RequestBody command: ProductCommand.Create): CommonResponse<Unit> {
        return CommonResponse(productFacade.registerProduct(command))
    }

    @LimitRequestPerTime(
        prefix="prefix:",
        ttl=1,
        ttlTimeUnit = TimeUnit.MINUTES,
        count=5
    )
    @PostMapping("/excel")
    fun registerProductsByExcel(@RequestBody command: ProductCommand.Create){
        //todo
    }
}