package io.gitee.zicai.jpa.service

import io.gitee.zicai.core.entity.App
import io.gitee.zicai.core.entity.QApp
import io.gitee.zicai.jpa.repo.AppRepo
import org.springframework.stereotype.Service

@Service
open class AppService : BaseService<AppRepo, App>() {

    open fun findOne(appName: String, appEnv: String): App {
        val qApp = QApp.app
        return repo.findOne(qApp.appName.eq(appName).and(qApp.appEnv.eq(appEnv)))
    }
}
