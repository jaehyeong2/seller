package jjfactory.msa_study.infrastructure

import jjfactory.msa_study.domain.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
}