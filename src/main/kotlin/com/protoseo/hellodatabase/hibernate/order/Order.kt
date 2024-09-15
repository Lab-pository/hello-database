package com.protoseo.hellodatabase.hibernate.order

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JavaType
import org.hibernate.annotations.JavaTypeRegistration
import org.hibernate.annotations.SoftDelete
import org.hibernate.type.YesNoConverter

@Entity
@Table(name = "orders")
@JavaTypeRegistration(javaType = OrderId::class, descriptorClass = OrderIdJavaType::class)
@SoftDelete(columnName = "deleted", converter = YesNoConverter::class)
class Order(
    @Id
    @JavaType(OrderIdJavaType::class)
    val id: OrderId,

    val name: String,
) {
}
