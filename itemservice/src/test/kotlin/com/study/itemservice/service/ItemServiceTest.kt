package com.study.itemservice.service

import com.study.itemservice.domain.item.Album
import com.study.itemservice.domain.item.Book
import com.study.itemservice.domain.item.Movie
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.util.*

@SpringBootTest
@Transactional
internal class ItemServiceTest(
    @Autowired
    val itemService: ItemService
) {

    @Test
    fun saveItem() {
        // given
        val book = Book(name = "book1", price = 1000, author = "author1", isbn = "isbn1", stockQuantity = 10)
        itemService.saveItem(book)

        // when
        val findItem = itemService.findOne(book.id!!)

        // then
        assertThat(findItem).isEqualTo(book)
    }

    @Test
    fun findItems() {
        // given
        val book = Book(name = "book1", price = 1000, author = "author1", isbn = "isbn1", stockQuantity = 10)
        itemService.saveItem(book)
        val movie = Movie(name = "movie1", price = 1000, stockQuantity = 10, director = "director1", actor = "actor1")
        itemService.saveItem(movie)
        val album = Album(name = "movie1", price = 1000, stockQuantity = 10, artist = "artist1", etc = "etc")
        itemService.saveItem(album)

        // when
        val findBook = itemService.findOne(book.id!!)
        val findMovie = itemService.findOne(movie.id!!)
        val findAlbum = itemService.findOne(album.id!!)

        // then
        assertThat(itemService.findItems()).isEqualTo(listOf(findBook, findMovie, findAlbum))
    }
}