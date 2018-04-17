package io.gitee.zicai.test

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.gitee.zicai.core.entity.App
import io.gitee.zicai.core.vo.ResultVO
import io.gitee.zicai.server.controller.AppController
import io.gitee.zicai.test.console.errln
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.SpyBean

open class AppServiceTest : BaseTest() {

    override fun mvcTest(): Boolean = false

    @Autowired
    private lateinit var appController: AppController
    @SpyBean
    private lateinit var appControllerSpy: AppController

    @Before
    override fun before() {
        super.before()

        `when`(appController.appGet(anyString(), anyString())).thenReturn(ResultVO().also {
            it.data = App().also {
                it.appName = "appNameTest"
                it.appEnv = "appEnvTest"
            }
        })
        `when`(appControllerSpy.appGet(anyString(), anyString())).thenReturn(ResultVO().also {
            it.message = "msg via spy"
        })
    }

    @Test
    open fun testGet() {
        appController.appGet("test", "test")
                .let { jacksonObjectMapper().writeValueAsString(it) }
                .let { errln(">>> $it") }
    }

    @Test
    open fun testSpy() {
        appControllerSpy.appGet("test", "test")
                .let { jacksonObjectMapper().writeValueAsString(it) }
                .let { errln(">>> $it") }
    }
}