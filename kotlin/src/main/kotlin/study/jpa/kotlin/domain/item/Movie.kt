package study.jpa.kotlin.domain.item

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("M")
class Movie(
  name: String,
  price: Int,
  stockQuantity: Int,
  director: String,
  actor: String
) : Item(name, price, stockQuantity) {
  var director: String = director
  var actor: String = actor
}