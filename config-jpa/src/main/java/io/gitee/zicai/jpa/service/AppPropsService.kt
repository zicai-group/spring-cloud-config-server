package io.gitee.zicai.jpa.service

import io.gitee.zicai.core.entity.AppProps
import io.gitee.zicai.core.entity.QApp
import io.gitee.zicai.core.entity.QAppProps
import io.gitee.zicai.jpa.repo.AppPropsRepo
import org.springframework.stereotype.Service

@Service
open class AppPropsService : BaseService<AppPropsRepo, AppProps>() {

    open fun findProps(appName: String, appEnv: String): Map<String, Any> {
        val qAppProps = QAppProps.appProps
        val qApp = QApp.app
        val list = jpaQuery.select(qAppProps)
                .from(qAppProps, qApp)
                .where(qAppProps.appId.eq(qApp.id).and(qApp.appName.eq(appName)).and(qApp.appEnv.eq(appEnv)))
                .fetch()

        return list.takeIf { it.isNotEmpty() }
                ?.associateBy(AppProps::getPropKey, AppProps::getPropValue)
                ?: mapOf()
    }
}
