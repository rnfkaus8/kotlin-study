package com.study.itemservice.domain

import com.study.itemservice.domain.item.Item
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Category(
  @Id @GeneratedValue
  @Column(name = "category_id")
  var id: Long? = null,

  val name: String,

  @ManyToMany
  @JoinTable(name = "category_item",
    joinColumns = [JoinColumn(name = "category_id")],
    inverseJoinColumns = [JoinColumn(name = "item_id")]
  )
  var items: MutableList<Item>?,

  @ManyToOne
  @JoinColumn(name = "parent_id")
  val parent: Category,

  @OneToMany(mappedBy = "parent")
  var child: MutableList<Category>?
)
