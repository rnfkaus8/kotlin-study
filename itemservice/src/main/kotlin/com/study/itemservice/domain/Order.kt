package com.study.itemservice.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
  member: Member,

  delivery: Delivery,

  @Id @GeneratedValue
  @Column(name = "order_id")
  var id: Long? = null,

  @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
  val orderItems: MutableList<OrderItem> = ArrayList(),

  val orderDate: LocalDateTime,

  @Enumerated(EnumType.STRING)
  var status: OrderStatus, // 주문상태 [ORDER, CANCEL]
) {

  @ManyToOne
  @JoinColumn(name = "member_id")
  var member: Member = member
    set(member) {
      field = member
      member.orders.add(this)
    }

  @OneToOne(cascade = [CascadeType.ALL])
  @JoinColumn(name = "delivery_id")
  var delivery: Delivery = delivery
    set(value) {
      field = value
      delivery.order = this
    }

  fun addOrderItem(orderItem: OrderItem) {
    orderItems.add(orderItem)
    orderItem.order = this
  }

  /**
   * 주문 취소
   */
  fun cancel() {
    if (delivery.status == DeliveryStatus.CAMP) {
      throw IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.")
    }

    this.status = OrderStatus.CANCEL
    for (orderItem in orderItems) {
      orderItem.cancel()
    }
  }

  /**
   * 전체 주문 가격 조회
   */
  fun getTotalPrice(): Int {
    return orderItems.sumOf { it.getTotalPrice() }
  }

  companion object {
    fun createOrder(member: Member, delivery: Delivery, vararg orderItems: OrderItem): Order {
      val order = Order(member = member, delivery = delivery, status = OrderStatus.ORDER, orderDate = LocalDateTime.now())
      for (orderItem in orderItems) {
        order.addOrderItem(orderItem)
      }
      return order
    }
  }
}
