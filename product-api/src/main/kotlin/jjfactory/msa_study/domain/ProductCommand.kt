package jjfactory.msa_study.domain

class ProductCommand {
    data class Create(
        val name: String,
        val sellerCode: String,
        val groups: List<ProductOptionGroupCommand.Create>
    ){
        fun toEntity(): Product {
            return Product(
                name = name,
                sellerCode = sellerCode
            )
        }
    }
}

class ProductOptionGroupCommand {
    data class Create(
        val name: String,
        val options: List<ProductOptionCommand.Create> = listOf()
    )
}

class ProductOptionCommand {
    data class Create(
        val name: String
    )
}

