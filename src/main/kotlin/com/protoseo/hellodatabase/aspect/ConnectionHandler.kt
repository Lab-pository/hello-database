package com.protoseo.hellodatabase.aspect

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ConnectionHandler(
    private val target: Any,
    private val queryCounter: QueryCounter
) : InvocationHandler {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun invoke(proxy: Any?, method: Method, args: Array<Any?>?): Any {
        countPrepareStatement(method)
        logQueryCount(method)
        return method.invoke(target, args)
    }

    private fun logQueryCount(method: Method) {
        log.info("\n====== count : {} =======\n", queryCounter.getValue().toString())
        if (method.name == "close") {
            log.info("\n====== count : {} =======\n", queryCounter.getValue().toString())
        }
    }

    private fun countPrepareStatement(method: Method) {
        if (method.name == "prepareStatement") {
            queryCounter.increase()
        }
    }
}
