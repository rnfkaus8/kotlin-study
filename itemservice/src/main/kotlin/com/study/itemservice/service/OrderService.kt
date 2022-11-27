package com.study.itemservice.service

import com.study.itemservice.domain.Delivery
import com.study.itemservice.domain.DeliveryStatus
import com.study.itemservice.domain.Order
import com.study.itemservice.domain.OrderItem
import com.study.itemservice.repository.ItemRepository
import com.study.itemservice.repository.MemberRepository
import com.study.itemservice.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderService(
  private val orderRepository: OrderRepository,
  private val memberRepository: MemberRepository,
  private val itemRepository: ItemRepository,
) {

    // 주문
    @Transactional
    fun order(memberId: Long, itemId: Long, count: Int): Long {
        val member = memberRepository.findOne(memberId)
        val item = itemRepository.findOne(itemId)

        // 배송정보 생성
        val delivery = Delivery(address = member.address, status = DeliveryStatus.READY)

        // 주문상품 생성
        val orderItem = OrderItem.createOrderItem(item, item.price, count)

        // 주문생성
        val order = Order.createOrder(member, delivery, orderItem)

        orderRepository.save(order)
        return order.id!!
    }

    // 취소
    @Transactional
    fun cancelOrder(orderId: Long) {
        val order = orderRepository.findOne(orderId)
        order.cancel()
    }

    // 검색
}