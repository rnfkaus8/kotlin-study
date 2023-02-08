package study.jpa.kotlin.domain.item

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("B")
class Book(
  name: String,
  price: Int,
  stockQuantity: Int,
  author: String,
  isbn: String
) : Item(name, price, stockQuantity) {
  var author: String = author
  var isbn: String = isbn
}