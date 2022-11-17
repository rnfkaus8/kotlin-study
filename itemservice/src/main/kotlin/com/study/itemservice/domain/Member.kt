package com.study.itemservice.domain

import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Member(
  @Id @GeneratedValue
  @Column(name = "member_id")
  var id: Long? = null,

  val name: String,

  @Embedded
  val address: Address,

  @OneToMany(mappedBy = "member")
  val orders: MutableList<Order> = mutableListOf(),
)