package jjfactory.msa_study.infrastructure

import jjfactory.msa_study.LimitRequestPerTime
import org.aspectj.lang.ProceedingJoinPoint
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.script.DefaultRedisScript
import org.springframework.stereotype.Component

@Component
class RateLimiterImpl(
    private val redisTemplate: RedisTemplate<String, Any>,
    private val defaultRedisScript: DefaultRedisScript<Long>
) : RateLimiter {
    override fun tryApiCall(key: String, limitRequestPerTime: LimitRequestPerTime, joinPoint: ProceedingJoinPoint) {
        TODO("Not yet implemented")
    }
}가