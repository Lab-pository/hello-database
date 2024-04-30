package com.protoseo.hellodatabase.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id

@Entity
class Team(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,
    var name: String
) {
}
