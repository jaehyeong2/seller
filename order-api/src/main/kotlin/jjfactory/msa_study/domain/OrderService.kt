package jjfactory.msa_study.domain

interface OrderService {
    fun createOrder(command: OrderCommand.Create): Long
}