package io.gitee.zicai.biz.service

import com.baomidou.mybatisplus.core.conditions.Wrapper
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import io.gitee.zicai.core.entity.BaseEntity

abstract class BaseService<M : BaseMapper<T>, T : BaseEntity> : ServiceImpl<M, T>() {

    fun selectByPrimaryKey(id: Long?): T {
        return this.getById(id)
    }

    fun insert(entity: T): Int {
        return baseMapper.insert(entity)
    }

    fun deleteByPrimaryKey(id: Long): Int {
        return baseMapper.deleteById(id)
    }

    fun deleteExample(wrapper: Wrapper<T>): Int {
        return baseMapper.delete(wrapper)
    }

    fun updateByPrimaryKey(entity: T): Int {
        return baseMapper.updateById(entity)
    }

    fun updateByExample(entity: T, wrapper: Wrapper<T>): Int {
        return baseMapper.update(entity, wrapper)
    }

    @JvmOverloads
    fun page(index: Int, size: Int, wrapper: Wrapper<T>? = null): IPage<T> {
        val page = Page<T>(index.toLong(), size.toLong())
        page.setDesc("create_time")
        return baseMapper.selectPage(page, wrapper)
    }
}
