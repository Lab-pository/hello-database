package com.protoseo.hellodatabase.hibernate.order

import java.sql.Types
import org.hibernate.usertype.UserTypeSupport

class OrderIdType : UserTypeSupport<OrderIdType>(OrderId::class.java, Types.BIGINT)


