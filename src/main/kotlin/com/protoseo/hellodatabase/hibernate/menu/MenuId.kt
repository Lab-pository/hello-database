package com.protoseo.hellodatabase.hibernate.menu

import jakarta.persistence.Embeddable

@Embeddable
data class MenuId(

    var id: Long,
)
