package com.protoseo.hellodatabase.repository

import jakarta.persistence.EntityManager
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.transaction.annotation.Transactional
import com.protoseo.hellodatabase.hibernate.cart.Cart
import com.protoseo.hellodatabase.hibernate.cart.NewCart

@TestConstructor(autowireMode = ALL)
@SpringBootTest(properties = ["spring.profiles.active:hibernate"])
class CartRepositoryTest(
    val cartRepository: CartRepository,
    val newCartRepository: NewCartRepository,
    val em: EntityManager) {

    @Test
    @Transactional
    fun insert() {
        em.persist(Cart())
        em.flush()
        em.clear()

        val result = em.createQuery("select c from Cart c", Cart::class.java)
            .resultList

        println(result.get(0).id)
    }

    @Test
    @Transactional
    fun save() {
        cartRepository.save(Cart()) // Select 쿼리 이후, Insert 쿼리 발생, 즉 2번의 쿼리가e 발생한다
        cartRepository.flush() // flush 하지 않으면, select 할 때, insert 쿼리 발생
        println("---------------------------")

        val list = cartRepository.findAll()

        println(list[0].id)
    }

    @Test
    @Transactional
    fun saveV2() {
        newCartRepository.save(NewCart()) // insert 쿼리 한번만 발생
        newCartRepository.flush()
        println("---------------------------")

        val list = newCartRepository.findAll()

        println(list[0].id)
    }
}
