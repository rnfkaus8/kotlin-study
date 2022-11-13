package com.study.itemservice.domain

import javax.persistence.Embeddable

@Embeddable
class Address(
  city: String,
  street: String,
  val city: String,
) {
  val city: String = city
  val street: String = street
  val zipcode: String = zipcode
}
