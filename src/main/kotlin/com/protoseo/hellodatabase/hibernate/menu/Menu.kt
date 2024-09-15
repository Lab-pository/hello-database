package com.protoseo.hellodatabase.hibernate.menu

import java.time.Instant
import java.util.Date
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.CurrentTimestamp
import org.hibernate.annotations.Generated
import org.hibernate.annotations.UpdateTimestamp
import org.hibernate.generator.EventType.INSERT
import org.hibernate.generator.EventType.UPDATE
import com.protoseo.hellodatabase.hibernate.base.MoneyConverter
import com.protoseo.hellodatabase.hibernate.generic.Money

@Entity
@Table(name = "Menu")
class Menu(

    @EmbeddedId
    val id: MenuId,

    @Convert(converter = MoneyConverter::class) // ?? insert이후 update 쿼리를 발생시킨다., data class 가 아니어서 equals hashcode 없어서 다시 비교함
    val price: Money,

    val name: String,

    @CurrentTimestamp(event = [INSERT])
    val currentCreatedAt: Instant? = null,

    @CurrentTimestamp(event = [INSERT, UPDATE])
    var currentUpdatedAt: Instant? = null,

    @Column(name = "created_at")
    @CreationTimestamp
    val creationCreatedAt: Date? = null,

    @Column(name = "updated_at")
    @UpdateTimestamp
    var updateUpdatedAt: Date? = null,

    @Generated(event = [UPDATE])
    val fullName: String? = null,
) {
}
