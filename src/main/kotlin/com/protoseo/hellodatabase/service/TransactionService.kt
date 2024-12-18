package com.protoseo.hellodatabase.service

import javax.sql.DataSource
import org.springframework.jdbc.datasource.DataSourceUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import com.protoseo.hellodatabase.entity.Team
import com.protoseo.hellodatabase.repository.TeamRepository

@Service
class TransactionService(
    private val teamRepository: TeamRepository,
    private val dataSource: DataSource,
) {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun createTeamsWithNewTx(name: String) {
        println(DataSourceUtils.getConnection(dataSource))
        val team = teamRepository.save(Team(name = name))
        println(team)
    }

    @Transactional
    fun createTeamsWithSameTx(name: String) {
        println(DataSourceUtils.getConnection(dataSource))
        val team = teamRepository.save(Team(name = name))
        println(team)
    }
}
