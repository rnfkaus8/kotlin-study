package study.jpa.kotlin.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Address(
  city: String,
  street: String,
  zipcode: String
) {
  @Column
  val city: String = city

  @Column
  val street: String = street

  @Column
  val zipcode: String = zipcode
}