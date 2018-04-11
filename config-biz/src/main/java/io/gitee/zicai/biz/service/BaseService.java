package io.gitee.zicai.biz.service;

import io.gitee.zicai.core.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

public abstract class BaseService<M extends Mapper<T>, T extends BaseEntity> {

    @Autowired
    protected M mapper;

    @Transactional
    public int insert(T entity) {
        return mapper.insertSelective(entity);
    }

    @Transactional
    public int updateByPrimaryKey(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Transactional
    public int updateByExample(T entity, Object example) {
        return mapper.updateByExampleSelective(entity, example);
    }
}
