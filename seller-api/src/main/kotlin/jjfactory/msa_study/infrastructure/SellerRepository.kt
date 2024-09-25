package jjfactory.msa_study.infrastructure

import jjfactory.msa_study.domain.Seller
import org.springframework.data.jpa.repository.JpaRepository

interface SellerRepository: JpaRepository<Seller, Long> {
}