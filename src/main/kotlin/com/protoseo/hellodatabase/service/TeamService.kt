package com.protoseo.hellodatabase.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.protoseo.hellodatabase.entity.Team
import com.protoseo.hellodatabase.repository.TeamRepository

@Service
class TeamService(
    private val teamRepository: TeamRepository
) {

    @Transactional
    fun createTeam(name: String): Long {
        val team = teamRepository.save(Team(name = name))
        return team.id!!
    }

    @Transactional(readOnly = true)
    fun getTeam(id: Long): Team {
        val team = teamRepository.findById(id).orElseThrow { IllegalArgumentException("Not Found Team") }
        return team
    }

    @Transactional(readOnly = true)
    fun getTeams(): List<Team> {
        return teamRepository.findAll()
    }
}
