package com.protoseo.hellodatabase.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.protoseo.hellodatabase.hibernate.order.Order
import com.protoseo.hellodatabase.hibernate.order.OrderId

interface OrderRepository : JpaRepository<Order, OrderId> {
}
