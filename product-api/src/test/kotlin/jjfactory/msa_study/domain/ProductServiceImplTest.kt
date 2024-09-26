package jjfactory.msa_study.domain

import jjfactory.msa_study.infrastructure.ProductRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional


@SpringBootTest
class ProductServiceImplTest{
    @Autowired
    private lateinit var productService: ProductServiceImpl

    @Autowired
    private lateinit var productRepository: ProductRepository

    @BeforeEach
    fun setUp(){
        productRepository.deleteAll()
    }

    @Test
    fun `저장 메소드 성공 시 상품 옵션 옵션그룹 모두 디비에 저장된다`(){
        val optionCommand = ProductOptionCommand.Create(
            name = "optionA"
        )

        val groupCommand = ProductOptionGroupCommand.Create(
            name = "group a",
            options = listOf(optionCommand)
        )

        val command = ProductCommand.Create(
            name = "Test",
            sellerCode = "test",
            groups = mutableListOf(groupCommand)
        )

        //when
        productService.registerProduct(command)

        //then
        val findAll = productRepository.findAll()
        assertThat(findAll.size).isNotZero()
    }
}