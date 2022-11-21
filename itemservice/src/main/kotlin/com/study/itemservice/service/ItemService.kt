package com.study.itemservice.service

import com.study.itemservice.domain.item.Item
import com.study.itemservice.repository.ItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ItemService(
    val itemRepository: ItemRepository
) {

    @Transactional
    fun saveItem(item: Item) {
        itemRepository.save(item)
    }

    fun findItems(): MutableList<Item> {
        return itemRepository.findAll()
    }

    fun findOne(id: Long): Item {
        return itemRepository.findOne(id)
    }
}