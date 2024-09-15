package com.protoseo.hellodatabase.hibernate.base

import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator
import com.github.f4b6a3.tsid.TsidCreator

class TsidGenerator : IdentifierGenerator {
    override fun generate(session: SharedSessionContractImplementor?, obj: Any?): Long {
        return TsidCreator.getTsid().toLong()
    }
}
