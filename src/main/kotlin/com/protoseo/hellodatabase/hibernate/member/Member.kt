package com.protoseo.hellodatabase.hibernate.member

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import com.protoseo.hellodatabase.hibernate.base.TsidGenerator

@Entity
class Member(
    @Id
    @GeneratedValue(generator = "TsidGenerator")
    @GenericGenerator(name = "TsidGenerator", type = TsidGenerator::class)
    val id: Long? = null,

    val name: String
) {
}
