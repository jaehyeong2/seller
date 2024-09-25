package jjfactory.msa_study.domain

import java.time.LocalDateTime

class SellerInfo {
    data class Detail(
        val id: Long,
        val name: String,
        val bizNum: String,
        val createdAt: LocalDateTime,
        val updatedAt: LocalDateTime,
    )
}