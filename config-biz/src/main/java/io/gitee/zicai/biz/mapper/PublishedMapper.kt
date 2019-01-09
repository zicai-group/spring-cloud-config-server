package io.gitee.zicai.biz.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import io.gitee.zicai.core.entity.Published
import org.apache.ibatis.annotations.Param

interface PublishedMapper : BaseMapper<Published> {

    fun getLast(@Param("appName") appName: String, @Param("appEnv") appEnv: String): Published

    fun getLastOne(@Param("appId") appId: Long?): Published
}