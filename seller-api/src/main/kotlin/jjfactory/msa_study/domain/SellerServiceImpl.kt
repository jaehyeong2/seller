package jjfactory.msa_study.domain

import jjfactory.msa_study.infrastructure.SellerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class SellerServiceImpl(
    private val sellerRepository: SellerRepository,
    private val sellerReader: SellerReader
) : SellerService {


    override fun findById(id: Long): SellerInfo.Detail {
        return sellerReader.findByIdOrThrow(id).let {
            SellerInfo.Detail(
                id = it.id!!,
                name = it.name,
                bizNum = it.bizNum,
                createdAt = it.createdAt!!,
                updatedAt = it.updatedAt!!
            )
        }
    }

    @Transactional
    override fun store(command: SellerCommand.Create): Long {
        val seller = command.toEntity()
        return sellerRepository.save(seller).id!!
    }
}