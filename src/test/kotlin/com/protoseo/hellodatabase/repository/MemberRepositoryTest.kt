package com.protoseo.hellodatabase.repository

import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.transaction.annotation.Transactional
import com.protoseo.hellodatabase.hibernate.member.Member
import com.protoseo.hellodatabase.specification.MemberSpecs

@TestConstructor(autowireMode = ALL)
@SpringBootTest(properties = ["spring.profiles.active:hibernate"])
class MemberRepositoryTest(
    val memberRepository: MemberRepository,
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
    fun insertMultiThread() { // TODO
        em.persist(Member(name = "Test"))
        em.flush()
        em.clear()

        val result = em.createQuery("select m from Member m", Member::class.java)
            .resultList;

        println(result.get(0).id)
    }

    @Test
    @Transactional
    fun save() {
        memberRepository.save(Member(name = "Test")) // insert 쿼리 한번만 발생
        memberRepository.flush()
        println("----------------------")

        val members = memberRepository.findAll()
        println(members[0].id)
    }

    @Test
    @Transactional
    fun specificationTest() {
        memberRepository.save(Member(name = "hello1", age = 16, gender = false))
        memberRepository.save(Member(name = "hello2", age = 17, gender = false))
        memberRepository.save(Member(name = "hello3", age = 18, gender = false))
        memberRepository.save(Member(name = "hello4", age = 19, gender = false))
        memberRepository.save(Member(name = "hello5", age = 20, gender = true))
        memberRepository.flush()

        Assertions.assertThat(memberRepository.findAll(MemberSpecs.isManMember()).size).isEqualTo(1)
        Assertions.assertThat(memberRepository.findAll(MemberSpecs.lessThan18Member()).size).isEqualTo(2)
    }
}
