package com.study.itemservice.domain.item

import com.study.itemservice.domain.Category
import com.study.itemservice.exception.NotEnoughStockException
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Table(name = "item")
abstract class Item(
    var name: String,
    var price: Int,
    var stockQuantity: Int,
    @ManyToMany(mappedBy = "items")
    var categorise: MutableList<Category> = mutableListOf(),

    @Id @GeneratedValue
    @Column(name = "item_id")
    var id: Long? = null
) {
    // 비지니스 로직
    fun addStock(quantity: Int) {
        this.stockQuantity -= quantity
    }

    fun removeStock(quantity: Int) {
        val restStock = this.stockQuantity - quantity
        if (restStock < 0) {
            throw NotEnoughStockException("need more stock")
        }
        this.stockQuantity -= quantity
    }
}