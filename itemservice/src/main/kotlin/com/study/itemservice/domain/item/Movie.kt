package com.study.itemservice.domain.item

import com.study.itemservice.domain.item.Item
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("M")
class Movie(
    var director: String,
    var actor: String,
    name: String,
    price: Int,
    stockQuantity: Int,
) : Item(name, price, stockQuantity)