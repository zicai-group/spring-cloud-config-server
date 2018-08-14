package io.gitee.zicai.jpa.test

import io.gitee.zicai.jpa.JpaApp
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [JpaApp::class])
open class BaseTest {

    @Autowired
    private lateinit var context: WebApplicationContext

    protected lateinit var mockMvc: MockMvc

    open fun mvcTest(): Boolean = false

    @Before
    open fun before() {
        if (mvcTest()) {
            mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
        }
    }
}