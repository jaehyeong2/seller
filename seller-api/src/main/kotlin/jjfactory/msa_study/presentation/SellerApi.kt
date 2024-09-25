package jjfactory.msa_study.presentation

import jjfactory.msa_study.CommonResponse
import jjfactory.msa_study.domain.SellerCommand
import jjfactory.msa_study.domain.SellerInfo
import jjfactory.msa_study.domain.SellerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/sellers")
@RestController
class SellerApi(
    private val sellerService: SellerService
) {

    @PostMapping
    fun postSeller(@RequestBody command: SellerCommand.Create): CommonResponse<Unit> {
        sellerService.store(command)
        return CommonResponse.OK
    }

    @GetMapping("/{id}")
    fun getSeller(@PathVariable id: Long): CommonResponse<SellerInfo.Detail> {
        return CommonResponse(sellerService.findById(id))
    }

}