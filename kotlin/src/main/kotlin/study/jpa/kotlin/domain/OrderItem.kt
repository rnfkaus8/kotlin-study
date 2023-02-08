package study.jpa.kotlin.domain

import jakarta.persistence.*
import study.jpa.kotlin.domain.item.Item

@Entity
class OrderItem(
  item: Item,
  orderPrice: Int,
  count: Int
) {

  @Id
  @GeneratedValue
  @Column(name = "order_item_id")
  var id: Long? = null

  @ManyToOne
  @JoinColumn(name = "item_id")
  var item: Item = item

  @ManyToOne
  @JoinColumn(name = "order_id")
  var order: Order? = null

  var orderPrice: Int = orderPrice
  var count: Int = count
}