package jjfactory.msa_study

import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy
import java.util.concurrent.TimeUnit

@Target(allowedTargets = [AnnotationTarget.TYPE, AnnotationTarget.FUNCTION])
@Retention(AnnotationRetention.RUNTIME)
annotation class LimitRequestPerTime(
    /**
     * 분당호출 제한시킬 unique key prefix
     */
    val prefix: String = "",
    /**
     * 호출 제한 시간
     */
    val ttl: Int = 1,
    /**
     * 호출 제한 시간 단위
     */
    val ttlTimeUnit: TimeUnit,
    /**
     * 분당 호출제한 카운트
     */
    val count: Int
)
