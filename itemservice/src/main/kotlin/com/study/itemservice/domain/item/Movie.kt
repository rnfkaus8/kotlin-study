package com.study.itemservice.domain.item

import com.study.itemservice.domain.item.Item
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("M")
class Movie(
  var director: String,
  var actor: String,
): Item()