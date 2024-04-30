package com.protoseo.hellodatabase.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Player(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,
    var name: String,
    var age: Int,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "team_id")
    var team: Team
) {
}
