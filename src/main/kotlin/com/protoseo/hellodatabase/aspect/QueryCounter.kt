package com.protoseo.hellodatabase.aspect

import java.util.concurrent.atomic.AtomicLong

class QueryCounter {

    private val count: AtomicLong = AtomicLong(0)

    fun increase() {
        count.getAndIncrement()
    }

    fun getValue(): Long {
        return count.get()
    }
}
