package com.study.itemservice.domain

import javax.persistence.*

@Entity
class Delivery(
  @Id @GeneratedValue
  @Column(name = "delivery_id")
  var id: Long? = null,

  @OneToOne(mappedBy = "delivery")
  var order: Order? = null,

  @Embedded
  val address: Address,

  @Enumerated(EnumType.STRING)
  val status: DeliveryStatus, //READY, CAMP
)
