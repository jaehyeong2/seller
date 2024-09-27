package jjfactory.msa_study.infrastructure

import jjfactory.msa_study.domain.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long> {
}