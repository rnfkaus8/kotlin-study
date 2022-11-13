package com.study.itemservice.domain.item

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Table(name = "item")
abstract class Item {
  @Id @GeneratedValue
  @Column(name = "item_id")
  private var id: Long? = null

  var name: String? = null
  var price: Int? = null
  var stockQuantity: Int? = null
}