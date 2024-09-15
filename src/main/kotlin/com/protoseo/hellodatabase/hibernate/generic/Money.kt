package com.protoseo.hellodatabase.hibernate.generic

import java.math.BigDecimal

data class Money(val amount: BigDecimal) {

    companion object {
        fun wons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }
    }
}
