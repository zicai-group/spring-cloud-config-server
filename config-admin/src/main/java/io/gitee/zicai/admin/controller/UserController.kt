package io.gitee.zicai.admin.controller

import io.gitee.zicai.core.common.BaseController
import io.gitee.zicai.core.vo.ResultVO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
open class UserController : BaseController() {

    @PostMapping("/login")
    open fun login(username: String?, password: String?): ResultVO {
        if (username.isNullOrBlank() || !username.equals("admin")) {
            return onFail("用户不存在！")
        }
        if (password.isNullOrBlank() || !password.equals("123456")) {
            return onFail("密码错误！")
        }
        return onSuccess("登录成功！")
    }

    @GetMapping("/logout/{username}")
    open fun logout(@PathVariable username: String?): ResultVO {
        return onSuccess("退出成功！")
    }
}