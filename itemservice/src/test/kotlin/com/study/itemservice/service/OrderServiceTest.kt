package com.study.itemservice.service

import com.study.itemservice.domain.Address
import com.study.itemservice.domain.Member
import com.study.itemservice.domain.Order
import com.study.itemservice.domain.OrderStatus
import com.study.itemservice.domain.item.Book
import com.study.itemservice.exception.NotEnoughStockException
import com.study.itemservice.repository.OrderRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@SpringBootTest
@Transactional
internal class OrderServiceTest(
  @Autowired
  val em: EntityManager,

  @Autowired
  val orderService: OrderService,

  @Autowired
  val orderRepository: OrderRepository,
) {

  @Test
  fun 상품주문() {
    // given
    val member = createMember("member1", Address("seoul", "gangnam", "123-123"))

    val book = createBook("book1", 10000, 10, "mr kim", "isbn1")

    val orderCount = 2

    // when
    val orderId = orderService.order(memberId = member.id, itemId = book.id!!, count = orderCount)

    // then
    val getOrder: Order = orderRepository.findOne(orderId)

    assertEquals(OrderStatus.ORDER, getOrder.status, "상품 주문시 상태는 ORDER")
    assertEquals(1, getOrder.orderItems.size, "주문한 상품 종류 수가 정확해야 한다.")
    assertEquals(10000 * orderCount, getOrder.getTotalPrice(), "주문 가격은 가격 * 수량이다.")
    assertEquals(8, book.stockQuantity, "주문 수량만큼 재고가 줄어야 한다")
  }

  @Test
  fun 상품주문_재고수량초과() {
    // given
    val member = createMember("member1", Address("seoul", "gangnam", "123-123"))
    val book = createBook("book1", 10000, 10, "mr kim", "isbn1")

    val orderCount: Int = 11;

    // when

    assertThrows(NotEnoughStockException::class.java) {
      orderService.order(memberId = member.id, itemId = book.id!!, count = orderCount)
    }
  }

  @Test
  fun 주문취소() {
    // given
    val member = createMember("member1", Address("seoul", "gangnam", "123-123"))
    val item = createBook("book1", 10000, 10, "kim", "isbn")
    val orderCount = 2

    val orderId = orderService.order(member.id, item.id!!, orderCount)

    // when
    orderService.cancelOrder(orderId)

    // then
    val findOrder = orderRepository.findOne(orderId)

    assertEquals(OrderStatus.CANCEL, findOrder.status, "주문 취소시 상태는 CANCEL 이다.")
    assertEquals(10, item.stockQuantity, "주문 취소된 상품은 그만큼 재고가 증가해야 한다.")
  }

  private fun createBook(name: String, price: Int, stockQuantity: Int, author: String, isbn: String): Book {
    val book = Book(name = name, price = price, stockQuantity = stockQuantity, author = author, isbn = isbn)
    em.persist(book)
    return book
  }

  private fun createMember(name: String, address: Address): Member {
    val member = Member(name = name, address = address)
    em.persist(member)
    return member
  }
}
