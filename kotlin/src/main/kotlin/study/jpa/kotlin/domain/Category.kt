package study.jpa.kotlin.domain

import jakarta.persistence.*
import study.jpa.kotlin.domain.item.Item

@Entity
class Category(
  name: String,
  parent: Category?
) {
  @Id
  @GeneratedValue
  @Column(name = "category_id")
  var id: Long? = null

  var name: String = name

  @ManyToMany
  @JoinTable(
    name = "category_item",
    joinColumns = [JoinColumn(name = "category_id")],
    inverseJoinColumns = [JoinColumn(name = "item_id")]
  )
  var items: MutableList<Item> = arrayListOf()

  @ManyToOne
  @JoinColumn(name = "parent_id")
  var parent: Category? = parent

  @OneToMany(mappedBy = "parent")
  var child: MutableList<Category> = arrayListOf()
}