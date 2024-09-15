package com.protoseo.hellodatabase.hibernate.base

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import com.protoseo.hellodatabase.hibernate.generic.Money

@Converter
class MoneyConverter : AttributeConverter<Money, Long> {

    override fun convertToDatabaseColumn(money: Money): Long {
        return money.amount.toLong()
    }

    override fun convertToEntityAttribute(amount: Long): Money {
        return Money.wons(amount)
    }
}
