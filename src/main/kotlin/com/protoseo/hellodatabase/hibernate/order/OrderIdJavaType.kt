package com.protoseo.hellodatabase.hibernate.order

import java.sql.Types
import org.hibernate.type.descriptor.WrapperOptions
import org.hibernate.type.descriptor.java.AbstractClassJavaType
import org.hibernate.type.descriptor.jdbc.JdbcType
import org.hibernate.type.descriptor.jdbc.JdbcTypeIndicators

class OrderIdJavaType : AbstractClassJavaType<OrderId>(OrderId::class.java) {

    override fun getRecommendedJdbcType(indicators: JdbcTypeIndicators): JdbcType {
        return indicators.typeConfiguration
            .jdbcTypeRegistry
            .getDescriptor(Types.BIGINT)
    }

    override fun toString(value: OrderId): String {
        return value.value.toString()
    }

    override fun fromString(string: CharSequence): OrderId {
        try {
            return javaType.getDeclaredConstructor(Long::class.java).newInstance(string.toString().toLong())
        } catch (ex: Exception) {
            throw IllegalStateException(ex)
        }
    }

    override fun <X : Any?> wrap(value: X, options: WrapperOptions?): OrderId {
        if (value == null) {
            return OrderId(0L)
        }

        if (value is OrderId) {
            return value
        }
        if (value is Long) {
            try {
                return javaType.getDeclaredConstructor(Long::class.java).newInstance(value)
            } catch (ex: java.lang.Exception) {
                throw java.lang.IllegalStateException(ex)
            }
        }

        throw unknownWrap(value.javaClass)
    }

    override fun <X : Any?> unwrap(value: OrderId?, type: Class<X>?, options: WrapperOptions?): X? {
        if (value == null) {
            return null
        }
        if (java.lang.Long::class.java.isAssignableFrom(type)) {
            return value.value as X
        }
        if (OrderId::class.java.isAssignableFrom(type)) {
            return value.value as X
        }
        throw unknownUnwrap(type)
    }

}
