package io.gitee.zicai.biz.service

import io.gitee.zicai.biz.mapper.AppPropsMapper
import io.gitee.zicai.core.entity.AppProps
import org.springframework.stereotype.Service

@Service
open class AppPropsService : BaseService<AppPropsMapper, AppProps>() {

    fun findProps(appName: String, appEnv: String): Map<String?, Any?> {
        return baseMapper.findProps(appName, appEnv).associate { it.propKey to it.propValue }
    }
}
