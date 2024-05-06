package com.protoseo.hellodatabase.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.protoseo.hellodatabase.entity.Team

interface TeamRepository : JpaRepository<Team, Long> {

    fun findByName(name: String): Team?
}
