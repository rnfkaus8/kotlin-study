package study.jpa.kotlin.domain.item

import jakarta.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
abstract class Item(
  name: String,
  price: Int,
  stockQuantity: Int
) {
  @Id
  @GeneratedValue
  @Column(name = "item_id")
  var id: Long? = null

  var name: String = name
  var price: Int = price
  var stockQuantity: Int = stockQuantity
}