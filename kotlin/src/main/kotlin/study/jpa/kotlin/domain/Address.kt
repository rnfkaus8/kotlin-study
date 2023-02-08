package study.jpa.kotlin.domain

import jakarta.persistence.Access
import jakarta.persistence.AccessType
import jakarta.persistence.Embeddable

@Embeddable
@Access(AccessType.FIELD)
class Address(
  val city: String,
  val street: String,
  val zipcode: String
)