package com.protoseo.hellodatabase.service

import javax.sql.DataSource
import org.springframework.jdbc.datasource.DataSourceUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.protoseo.hellodatabase.entity.Team
import com.protoseo.hellodatabase.repository.TeamRepository

@Service
class TeamService(
    private val teamRepository: TeamRepository,
    private val transactionService: TransactionService,
    private val dataSource: DataSource
) {

    fun createManyTeamWithNewTx() {
        println(DataSourceUtils.getConnection(dataSource))
        println("-----------------------------------------------")
        for (i in 1..10) {
            transactionService.createTeamsWithNewTx(i.toString())
        }
    }

    fun createManyTeamWithSameTx() {
        println(DataSourceUtils.getConnection(dataSource))
        println("-----------------------------------------------")
        for (i in 1..10) {
            transactionService.createTeamsWithSameTx(i.toString())
        }
    }

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
    fun getTeam(name: String): Team {
        val team = teamRepository.findByName(name) ?: throw IllegalArgumentException("Not Found Team")
        return team
    }

    @Transactional(readOnly = true)
    fun getTeams(): List<Team> {
        return teamRepository.findAll()
    }
}
