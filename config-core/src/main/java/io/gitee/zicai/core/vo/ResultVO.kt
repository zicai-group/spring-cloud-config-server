package io.gitee.zicai.core.vo

import java.io.Serializable

class ResultVO : Serializable {

    var isSuccess: Boolean = false

    var status: Int = 0

    var message: String? = null

    var data: Any? = null
}
