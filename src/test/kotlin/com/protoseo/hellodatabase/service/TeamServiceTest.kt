package com.protoseo.hellodatabase.service

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL

@TestConstructor(autowireMode = ALL)
@SpringBootTest(properties = ["spring.profiles.active:hibernate"])
class TeamServiceTest(
    private val teamService: TeamService
) {

    @Test
    @Rollback(false)
    fun newTransactionalTest() {
        teamService.createManyTeamWithNewTx()

        val team = teamService.getTeam("1")
        println(team)
    }

    @Test
    @Rollback(false)
    fun sameTransactionalTest() {
        teamService.createManyTeamWithSameTx()

        val team = teamService.getTeam("1")
        println(team)
    }
}
