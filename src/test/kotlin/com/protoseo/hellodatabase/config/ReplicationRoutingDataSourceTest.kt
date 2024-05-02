package com.protoseo.hellodatabase.config

import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.jvm.isAccessible
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import com.protoseo.hellodatabase.config.DataSourceType.READ
import com.protoseo.hellodatabase.config.DataSourceType.WRITE

@SpringBootTest
class ReplicationRoutingDataSourceTest {

    private val methodName = "determineCurrentLookupKey"

    @Test
    @Transactional
    fun `쓰기 작업 실행`() {
        val result = ReplicationRoutingDataSource::class
            .declaredFunctions.find { it.name == methodName }
            .also { it?.isAccessible = true }
            ?.call(ReplicationRoutingDataSource())

        assertThat(result).isEqualTo(WRITE)
    }

    @Test
    @Transactional(readOnly = true)
    fun `읽기 작업 실행`() {
        val result = ReplicationRoutingDataSource::class
            .declaredFunctions.find { it.name == methodName }
            .also { it?.isAccessible = true }
            ?.call(ReplicationRoutingDataSource())

        assertThat(result).isEqualTo(READ)
    }
}
