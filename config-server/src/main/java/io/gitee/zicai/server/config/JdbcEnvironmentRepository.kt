package io.gitee.zicai.server.config

import io.gitee.zicai.biz.service.AppPropsService
import org.springframework.cloud.config.environment.Environment
import org.springframework.cloud.config.environment.PropertySource
import org.springframework.cloud.config.server.environment.EnvironmentRepository
import org.springframework.core.Ordered
import org.springframework.util.StringUtils

/**
 * JdbcEnvieramentRep
 * @author zicai
 * @since 2018-03-21
 */
open class JdbcEnvironmentRepository(private val appPropsService: AppPropsService) : EnvironmentRepository, Ordered {

    private var order = Ordered.LOWEST_PRECEDENCE - 10

    override fun findOne(application: String, profile: String, label: String?): Environment {
        var profile = profile.takeIf { it.isNotEmpty() } ?: "default"
        val label = label?.takeIf { it.isNotEmpty() } ?: "master"
        var config = application
        if (!profile.startsWith("default")) {
            profile = "default,$profile"
        }
        if (!config.startsWith("application")) {
            config = "application,$config"
        }

        val applications = StringUtils.commaDelimitedListToStringArray(config).distinct().toList().asReversed()
        val profiles = StringUtils.commaDelimitedListToStringArray(profile)
        val envs = profiles.distinct().toList().asReversed()

        val environment = Environment(application, profiles, label, null, null)
        applications.forEach { app ->
            envs.forEach { env ->
                env.let { appPropsService.findProps(app, it) }
                        .takeIf { it.isNotEmpty() }
                        ?.let { PropertySource("$app-$env", it) }
                        ?.let { environment.add(it) }
            }
        }

        return environment
    }

    override fun getOrder(): Int {
        return this.order
    }
}
