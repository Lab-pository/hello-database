package com.protoseo.hellodatabase.repository

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class TeamRepositoryTest {

    private val id = 1L
    private val name = "Hello"

    @Autowired
    lateinit var teamRepository: TeamRepository

    @Test
    fun findIdAndId() { // 총 쿼리 1번 발생
        teamRepository.findById(id) // Persistence Context 1차 캐시에 저장
        teamRepository.findById(id) // 식별자를 이용해서 검색하므로 캐시에서 찾아서 사용
    }

    @Test
    fun findByNameAndId() { // 총 쿼리 1번 발생
        teamRepository.findByName(name) // Persistence Context 1차 캐시에 저장
        teamRepository.findById(1L) // 식별자를 이용해서 검색하므로 캐시에서 찾아서 사용
    }

    @Test
    fun findByIdAndName() { // 총 쿼리 2번 발생
        teamRepository.findById(1L) // Persistence Context 1차 캐시에 저장
        teamRepository.findByName(name) // 식별자를 이용해서 검색하지 않으므로 다시 한번 쿼리가 나감
    }

    @Test
    fun findByNameAndName() { // 총 쿼리 2번 발생
        teamRepository.findByName(name) // Persistence Context 1차 캐시에 저장
        teamRepository.findByName(name) // 식별자를 이용해서 검색하지 않으므로 다시 한번 쿼리가 나감
    }

}
