package io.gitee.zicai.biz.mapper;

import io.gitee.zicai.core.entity.AppProps;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AppPropsMapper extends Mapper<AppProps> {

    List<AppProps> findProps(@Param("appName")String appName, @Param("appEnv")String appEnv);
}