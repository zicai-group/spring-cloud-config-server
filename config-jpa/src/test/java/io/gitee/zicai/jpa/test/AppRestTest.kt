package io.gitee.zicai.jpa.test

import io.gitee.zicai.jpa.service.AppService
import io.gitee.zicai.jpa.test.console.err
import org.junit.Before
import org.junit.Test
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.util.Assert

open class AppRestTest : BaseTest() {

    override fun mvcTest(): Boolean = true

    @MockBean
    private lateinit var appService: AppService

    @Before
    override fun before() {
        super.before()
        Assert.notNull(this.mockMvc, ">>> mockmvc can not be null")

//        `when`(appService.findOne(anyString(), anyString())).thenReturn(App().also {
//            it.appName = "appNameTest"
//            it.appEnv = "appEnvTest"
//        })
    }

    @Test
    open fun appTest() {
        mockMvc.perform(get("/app/get/test/test")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    open fun jpaTest() {
        err(">>> enter jpa test")
        appService.findOne("config-sample", "test")?.let { err("${it.appName} -> ${it.appEnv}") }
    }
}