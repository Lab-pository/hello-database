package com.protoseo.hellodatabase.config

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager
import com.protoseo.hellodatabase.config.DataSourceType.READ
import com.protoseo.hellodatabase.config.DataSourceType.WRITE

class ReplicationRoutingDataSource : AbstractRoutingDataSource() {

    override fun determineCurrentLookupKey(): Any {
        val isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly()
        return if (isReadOnly) READ else WRITE
    }
}
