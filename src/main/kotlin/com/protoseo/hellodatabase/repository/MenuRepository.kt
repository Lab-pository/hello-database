package com.protoseo.hellodatabase.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.protoseo.hellodatabase.hibernate.menu.Menu
import com.protoseo.hellodatabase.hibernate.menu.MenuId

interface MenuRepository : JpaRepository<Menu, MenuId> {
}
