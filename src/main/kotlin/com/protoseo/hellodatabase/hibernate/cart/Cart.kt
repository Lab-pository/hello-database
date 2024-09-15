package com.protoseo.hellodatabase.hibernate.cart

import jakarta.persistence.Entity
import jakarta.persistence.Id
import com.github.f4b6a3.tsid.TsidCreator

@Entity
class Cart(
    @Id
    val id: Long = TsidCreator.getTsid256().toLong(),
) {
}
