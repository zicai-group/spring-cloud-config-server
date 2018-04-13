package io.gitee.zicai.biz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.gitee.zicai.core.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

public abstract class BaseService<M extends Mapper<T>, T extends BaseEntity> {

    @Autowired
    protected M mapper;

    public T selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int insert(T entity) {
        return mapper.insertSelective(entity);
    }

    @Transactional
    public int deleteByPrimaryKey(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public int deleteExample(Object example) {
        return mapper.deleteByExample(example);
    }

    @Transactional
    public int updateByPrimaryKey(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Transactional
    public int updateByExample(T entity, Object example) {
        return mapper.updateByExampleSelective(entity, example);
    }

    public PageInfo<T> page(int index, int size) {
        return page(index, size, null);
    }

    public PageInfo<T> page(int index, int size, Object example) {
        PageHelper.startPage(index, size);
        PageHelper.orderBy("create_time DESC");
        return new PageInfo<>(mapper.selectByExample(example));
    }
}
