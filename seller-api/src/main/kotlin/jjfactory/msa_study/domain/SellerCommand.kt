package jjfactory.msa_study.domain

class SellerCommand {
    data class Create(
        val name: String,
        val bizNum: String
    ){
        fun toEntity(): Seller {
            return Seller(
                name = name,
                bizNum = bizNum
            )
        }

    }
}