package jjfactory.msa_study.domain

import jjfactory.msa_study.infrastructure.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository
) : OrderService {
    override fun createOrder(command: OrderCommand.Create): Long {
        TODO("Not yet implemented")
    }
}