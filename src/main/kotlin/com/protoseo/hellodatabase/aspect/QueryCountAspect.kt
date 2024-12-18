package com.protoseo.hellodatabase.aspect

import java.lang.reflect.Proxy
import java.sql.Connection
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Aspect
class QueryCountAspect {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)
    private val counter: ThreadLocal<QueryCounter> = ThreadLocal()

    @Pointcut("execution(* javax.sql.DataSource.getConnection(..))")
    fun connectionPointcut() {
    }

    @Around("connectionPointcut()")
    fun getConnection(joinPoint: ProceedingJoinPoint): Any {
        log.info("----------- Hello {}", joinPoint)
        val connection = joinPoint.proceed() as Connection
        counter.set(QueryCounter())
        val proxy = getProxyConnection(connection, counter.get())
        counter.remove()
        return proxy
    }

    private fun getProxyConnection(connection: Connection, counter: QueryCounter): Connection {
        return Proxy.newProxyInstance(
            javaClass.classLoader,
            arrayOf<Class<*>>(Connection::class.java),
            ConnectionHandler(connection, counter)
        ) as Connection
    }
}
