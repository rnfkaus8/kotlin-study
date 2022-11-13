package com.study.itemservice.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
  @Id @GeneratedValue
  @Column(name = "order_id")
  var id: Long? = null,


  @ManyToOne
  @JoinColumn(name = "member_id")
  val member: Member,

  @OneToMany(mappedBy = "order")
  val orderItems: MutableList<OrderItem> = ArrayList(),

  @OneToOne
  @JoinColumn(name = "delivery_id")
  val delivery: Delivery,

  val orderDate: LocalDateTime,

  @Enumerated(EnumType.STRING)
  val status: OrderStatus, // 주문상태 [ORDER, CANCEL]
)
