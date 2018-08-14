package io.gitee.zicai.jpa.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.querydsl.QueryDslPredicateExecutor
import org.springframework.data.repository.NoRepositoryBean

/**
 * BaseRepo
 *
 * @author zicai
 * @since 2018-08-13
 */
@NoRepositoryBean
interface BaseRepo<T> : JpaRepository<T, Long>, JpaSpecificationExecutor<T>, QueryDslPredicateExecutor<T>
