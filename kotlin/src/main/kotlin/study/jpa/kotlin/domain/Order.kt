package study.jpa.kotlin.domain

import jakarta.persistence.*
import jakarta.persistence.FetchType.LAZY
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class Order(
  member: Member,
  delivery: Delivery,
  orderDate: LocalDateTime,
  status: OrderStatus
) {

  @Id
  @GeneratedValue
  @Column(name = "order_id")
  var id: Long? = null

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "member_id")
  var member: Member = member
    protected set(value) {
      field = value
      value.orders.add(this)
    }

  @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
  var orderItems: MutableList<OrderItem> = arrayListOf()

  @OneToOne(fetch = LAZY, cascade = [CascadeType.ALL])
  @JoinColumn(name = "delivery_id")
  var delivery: Delivery = delivery
    protected set(value) {
      field = value
      delivery.order = this
    }

  var orderDate: LocalDateTime = orderDate

  @Enumerated(EnumType.STRING)
  var status: OrderStatus = status

  fun addOrderItem(orderItem: OrderItem) {
    orderItems.add(orderItem)
    orderItem.order = this
  }
}