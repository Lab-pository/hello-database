package com.protoseo.hellodatabase.repository

import java.math.BigDecimal
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.transaction.annotation.Transactional
import com.protoseo.hellodatabase.hibernate.generic.Money
import com.protoseo.hellodatabase.hibernate.menu.Menu
import com.protoseo.hellodatabase.hibernate.menu.MenuId

@TestConstructor(autowireMode = ALL)
@SpringBootTest(properties = ["spring.profiles.active:hibernate"])
class MenuRepositoryTest(
    private val emf: EntityManagerFactory,
    private val em: EntityManager,
) {

    @Test
    @Transactional
    fun findTestWithTxAnnotation() {
        em.persist(Menu(MenuId(2L), Money(BigDecimal.valueOf(2000L)), "밥"));
        em.flush()
        em.clear()

        val result = em.find(Menu::class.java, MenuId(2L))
        assertThat(result.id.id).isEqualTo(2L)
        assertThat(result.creationCreatedAt).isNotNull()
        assertThat(result.updateUpdatedAt).isNotNull()
        assertThat(result.currentCreatedAt).isNotNull()
        assertThat(result.currentUpdatedAt).isNotNull()
        assertThat(result.creationCreatedAt).isNotEqualTo(result.currentCreatedAt)
//        assertThat(result.creationCreatedAt).isNotEqualTo(result.updateUpdatedAt)
    }

    @Test
    fun findTestWithTx() {
        val em = emf.createEntityManager()
        val tx = em.transaction
        tx.begin()
        em.persist(Menu(MenuId(1L), Money(BigDecimal.valueOf(1000L)), "밥"))
        tx.commit()

        val result = em.find(Menu::class.java, MenuId(1L))
        assertThat(result.id.id).isEqualTo(1L)
        assertThat(result.creationCreatedAt).isNotNull()
        assertThat(result.updateUpdatedAt).isNotNull()
        assertThat(result.currentCreatedAt).isNotNull()
        assertThat(result.currentUpdatedAt).isNotNull()
        assertThat(result.creationCreatedAt).isNotEqualTo(result.currentCreatedAt)
//        assertThat(result.creationCreatedAt).isNotEqualTo(result.updateUpdatedAt)
    }
}
