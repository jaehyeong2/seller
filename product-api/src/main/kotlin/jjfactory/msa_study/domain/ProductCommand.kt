package jjfactory.msa_study.domain

class ProductCommand {
    data class Create(
        val name: String,
        val groups: List<ProductOptionGroupCommand.Create>
    )
}

class ProductOptionGroupCommand {
    data class Create(
        val name: String,
        val options: List<ProductOptionCommand.Create>
    )
}

class ProductOptionCommand {
    data class Create(
        val name: String
    )
}

