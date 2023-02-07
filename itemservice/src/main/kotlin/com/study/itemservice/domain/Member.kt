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
  var id: Long = 0L,

  var name: String,

  @Embedded
  var address: Address,

  @OneToMany(mappedBy = "member")
  val orders: MutableList<Order> = mutableListOf(),
) {
  fun changeName(name: String) {
    this.name = name
  }

  fun changeAddress(address: Address) {
    this.address = Address(city = address.city, street = address.street, zipcode = address.zipcode)
  }
}