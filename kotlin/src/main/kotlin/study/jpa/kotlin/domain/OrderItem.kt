package study.jpa.kotlin.domain

import jakarta.persistence.*
import jakarta.persistence.FetchType.LAZY
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

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "item_id")
  var item: Item = item

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "order_id")
  var order: Order? = null

  var orderPrice: Int = orderPrice
  var count: Int = count
}