package com.study.itemservice.repository

import com.study.itemservice.domain.Member
import com.study.itemservice.domain.Order
import com.study.itemservice.domain.OrderSearch
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils
import javax.persistence.EntityManager
import javax.persistence.TypedQuery
import javax.persistence.criteria.*


@Repository
class OrderRepository(
    val em: EntityManager
) {

    fun save(order: Order) {
        em.persist(order)
    }

    fun findOne(id: Long): Order {
        return em.find(Order::class.java, id);
    }

     fun findAllByString(orderSearch: OrderSearch): MutableList<Order> {
         var jpql: String = "select o From Order o join o.member m"
         var isFirstCondition: Boolean = true

         if (orderSearch.orderStatus != null) {
             if (isFirstCondition) {
                 jpql += " where"
                 isFirstCondition = false
             } else {
                 jpql += " and"
             }
             jpql += " o.status = :status"
         }

         if (StringUtils.hasText(orderSearch.memberName)) {
             if (isFirstCondition) {
                 jpql += " where"
                 isFirstCondition = false
             } else {
                 jpql += " and"
             }
             jpql += " m.name like :name"
         }

         var query: TypedQuery<Order> = em.createQuery(jpql, Order::class.java)
             .setMaxResults(1000)

         if (orderSearch.orderStatus != null) {
             query = query.setParameter("status", orderSearch.orderStatus)
         }

         if (StringUtils.hasText(orderSearch.memberName)) {
             query = query.setParameter("name", orderSearch.memberName)
         }

         return query.resultList

     }

}