package com.protoseo.hellodatabase.controller

import java.net.URI
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import com.protoseo.hellodatabase.entity.Team
import com.protoseo.hellodatabase.service.TeamService

@RestController
class TeamController(
    private val teamService: TeamService
) {

    @PostMapping("/teams")
    fun createLeague(@RequestParam name: String): ResponseEntity<Nothing> {
        val teamId = teamService.createTeam(name)
        return ResponseEntity.created(URI.create("/teams/$teamId")).build()
    }

    @GetMapping("/teams/{id}")
    fun getTeam(@PathVariable id: Long): ResponseEntity<Team> {
        return ResponseEntity.ok(teamService.getTeam(id))
    }

    @GetMapping("/team")
    fun getTeams(): ResponseEntity<List<Team>> {
        return ResponseEntity.ok(teamService.getTeams())
    }
}
