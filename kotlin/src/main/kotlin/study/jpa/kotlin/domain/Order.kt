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

  @OneToMany(fetch = LAZY, mappedBy = "order")
  var orderItems: MutableList<OrderItem> = arrayListOf()

  @OneToOne(fetch = LAZY)
  @JoinColumn(name = "delivery_id")
  var delivery: Delivery = delivery

  var orderDate: LocalDateTime = orderDate

  @Enumerated(EnumType.STRING)
  var status: OrderStatus = status
}