package io.gitee.zicai.biz.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import io.gitee.zicai.core.entity.AppProps
import org.apache.ibatis.annotations.Param

interface AppPropsMapper : BaseMapper<AppProps> {

    fun findProps(@Param("appName") appName: String, @Param("appEnv") appEnv: String): List<AppProps>
}