package com.study.itemservice.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("B")
class Book(
  var author: String,
  var isbn: String,
  name: String,
  price: Int,
  stockQuantity: Int,
): Item(
  name,
  price,
  stockQuantity,
)