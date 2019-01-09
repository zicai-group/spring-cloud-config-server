package io.gitee.zicai.biz.service

import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import io.gitee.zicai.biz.mapper.AppMapper
import io.gitee.zicai.core.entity.App
import org.springframework.stereotype.Service

@Service
open class AppService : BaseService<AppMapper, App>() {

    fun findOne(appName: String, appEnv: String): App {
        val wrapper = KtQueryWrapper(App())
        wrapper.eq(App::appName, appName).eq(App::appEnv, appEnv)

        return baseMapper.selectOne(wrapper)
    }
}
