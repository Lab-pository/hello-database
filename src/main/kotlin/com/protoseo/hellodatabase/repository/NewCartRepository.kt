package com.protoseo.hellodatabase.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.protoseo.hellodatabase.hibernate.cart.NewCart

interface NewCartRepository : JpaRepository<NewCart, Long> {
}
