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
  val order: Order,

  val orderPrice: Int,
  val count: Int,
)