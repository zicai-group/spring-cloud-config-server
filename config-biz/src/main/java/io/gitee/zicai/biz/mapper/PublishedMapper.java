package io.gitee.zicai.biz.mapper;

import io.gitee.zicai.core.entity.Published;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface PublishedMapper extends Mapper<Published> {

    Published getLast(@Param("appName")String appName, @Param("appEnv")String appEnv);

    Published getLastOne(@Param("appId")Long appId);
}