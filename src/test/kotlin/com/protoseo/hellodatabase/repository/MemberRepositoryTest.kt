package com.protoseo.hellodatabase.repository

import java.math.BigDecimal
import jakarta.persistence.EntityManager
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.transaction.annotation.Transactional
import com.protoseo.hellodatabase.hibernate.generic.Money
import com.protoseo.hellodatabase.hibernate.member.Member
import com.protoseo.hellodatabase.hibernate.menu.Menu
import com.protoseo.hellodatabase.hibernate.menu.MenuId
import com.protoseo.hellodatabase.hibernate.order.Order
import com.protoseo.hellodatabase.hibernate.order.OrderId

@TestConstructor(autowireMode = ALL)
@SpringBootTest(properties = ["spring.profiles.active:hibernate"])
class MemberRepositoryTest(
    val em: EntityManager
) {

    @Test
    @Transactional
    fun insert() {
        em.persist(Member(name = "Test"))
        em.flush()
        em.clear()

        val result = em.createQuery("select m from Member m", Member::class.java)
            .resultList;

        println(result.get(0).id)
    }

    @Test
    @Transactional
    fun insertMultiThread() {
        em.persist(Member(name = "Test"))
        em.flush()
        em.clear()

        val result = em.createQuery("select m from Member m", Member::class.java)
            .resultList;

        println(result.get(0).id)
    }
}
