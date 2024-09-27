package jjfactory.msa_study.infrastructure

import jjfactory.msa_study.LimitRequestPerTime
import org.aspectj.lang.ProceedingJoinPoint

interface RateLimiter {
    fun tryApiCall(key: String, limitRequestPerTime: LimitRequestPerTime, joinPoint: ProceedingJoinPoint)
}