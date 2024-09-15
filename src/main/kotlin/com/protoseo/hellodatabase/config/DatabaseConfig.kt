package com.protoseo.hellodatabase.config

import javax.sql.DataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import org.springframework.transaction.PlatformTransactionManager
import com.protoseo.hellodatabase.config.DataSourceType.READ
import com.protoseo.hellodatabase.config.DataSourceType.WRITE
import com.zaxxer.hikari.HikariDataSource

@Profile("!hibernate")
@Configuration
class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.read")
    fun readDataSource(): DataSource {
        return DataSourceBuilder
            .create()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.write")
    fun writeDataSource(): DataSource {
        return DataSourceBuilder
            .create()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Bean
    fun routingDataSource(
        @Qualifier("writeDataSource") writeDataSource: DataSource,
        @Qualifier("readDataSource") readDataSource: DataSource
    ): DataSource {
        val dataSourceMap: MutableMap<Any, Any> = HashMap()
        dataSourceMap[WRITE] = writeDataSource
        dataSourceMap[READ] = readDataSource

        return ReplicationRoutingDataSource().also {
            it.setTargetDataSources(dataSourceMap)
            it.setDefaultTargetDataSource(writeDataSource)
        }
    }

    @Bean
    @Primary
    fun routingLazyDataSource(@Qualifier("routingDataSource") routingDataSource: DataSource): DataSource {
        return LazyConnectionDataSourceProxy(routingDataSource)
    }

    @Bean
    fun transactionManager(@Qualifier("routingLazyDataSource") dataSource: DataSource): PlatformTransactionManager {
        return DataSourceTransactionManager().also { it.dataSource = dataSource }
    }
}
