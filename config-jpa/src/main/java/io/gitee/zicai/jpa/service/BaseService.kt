package io.gitee.zicai.jpa.service

import com.querydsl.jpa.impl.JPAQueryFactory
import io.gitee.zicai.core.entity.BaseEntity
import io.gitee.zicai.jpa.repo.BaseRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

import javax.annotation.PostConstruct
import javax.persistence.EntityManager

abstract class BaseService<R : BaseRepo<T>, T : BaseEntity> {

    @Autowired
    protected lateinit var repo: R

    @Autowired
    private lateinit var entityManager: EntityManager

    lateinit var jpaQuery: JPAQueryFactory

    @PostConstruct
    open fun before() {
        this.jpaQuery = JPAQueryFactory(entityManager)
    }

    open fun selectById(id: Long): T {
        return repo.findOne(id)
    }

    @Transactional
    open fun insert(entity: T): T {
        return repo.save(entity)
    }

    @Transactional
    open fun deleteById(id: Long) {
        repo.delete(id)
    }
}
