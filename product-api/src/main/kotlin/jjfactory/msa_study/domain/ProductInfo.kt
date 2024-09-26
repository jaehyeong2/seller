package jjfactory.msa_study.domain

class ProductInfo {
    data class Detail(
        val name: String,
        val sellerCode: String,
        val groups: List<ProductOptionGroupInfo.Detail>
    )
}

class ProductOptionGroupInfo {
    data class Detail(
        val name: String,
        val options: List<ProductOptionInfo.Detail>
    )
}

class ProductOptionInfo {
    data class Detail(
        val name: String,
    )
}

