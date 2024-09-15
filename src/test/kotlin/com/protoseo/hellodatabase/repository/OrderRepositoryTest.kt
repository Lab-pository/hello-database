package com.protoseo.hellodatabase.repository

import java.math.BigDecimal
import jakarta.persistence.EntityManager
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.transaction.annotation.Transactional
import com.protoseo.hellodatabase.hibernate.generic.Money
import com.protoseo.hellodatabase.hibernate.menu.Menu
import com.protoseo.hellodatabase.hibernate.menu.MenuId
import com.protoseo.hellodatabase.hibernate.order.Order
import com.protoseo.hellodatabase.hibernate.order.OrderId

@SpringBootTest(properties = ["spring.profiles.active:hibernate"])
class OrderRepositoryTest {

    @Autowired
    lateinit var orderRepository: OrderRepository

    @Autowired
    lateinit var em: EntityManager

    @BeforeEach
    fun setUp() {
//        orderRepository.save(Order(id = OrderId(1L), name = "밥"))
    }

    @Test
    @Transactional
    fun findId() {
        em.persist(Order(OrderId(1L), "밥"))
        em.flush()
        em.clear()

    }
}
