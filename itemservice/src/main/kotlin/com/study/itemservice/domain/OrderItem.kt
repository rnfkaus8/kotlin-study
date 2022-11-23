package com.study.itemservice.domain

import com.study.itemservice.domain.item.Item
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class OrderItem(
  @Id @GeneratedValue
  @Column(name = "order_item_id")
  var id: Long? = null,

  @ManyToOne
  @JoinColumn(name = "item_id")
  val item: Item,

  @ManyToOne
  @JoinColumn(name = "order_id")
  var order: Order? = null,

  val orderPrice: Int,
  val count: Int,
) {
  /**
   * 주문 취소
   */
  fun cancel() {
    item.addStock(count)
  }

  //
  fun getTotalPrice(): Int {
    return orderPrice * count
  }

  companion object {
    fun createOrderItem(item: Item, orderPrice: Int, count: Int): OrderItem {
      val orderItem = OrderItem(item = item, orderPrice = orderPrice, count = count)
      item.removeStock(count)
      return orderItem
    }
  }
}