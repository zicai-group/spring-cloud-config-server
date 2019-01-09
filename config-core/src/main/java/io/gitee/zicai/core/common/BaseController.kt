package io.gitee.zicai.core.common

import io.gitee.zicai.core.vo.ResultVO

abstract class BaseController {

    protected fun onSuccess(data: Any?): ResultVO {
        return onSuccess(null, data)
    }

    @JvmOverloads
    protected fun onSuccess(message: String? = "操作成功!", data: Any? = null): ResultVO {
        return onSuccess(message, 1, data)
    }

    protected fun onSuccess(message: String?, status: Int, data: Any?) = ResultVO().also {
        it.isSuccess = true
        it.status = status
        it.message = message
        it.data = data
    }

    protected fun onFail(data: Any?): ResultVO {
        return onFail(null, data)
    }

    @JvmOverloads
    protected fun onFail(message: String? = "操作失败!", data: Any? = null): ResultVO {
        return onFail(message, 0, data)
    }

    protected fun onFail(message: String?, status: Int, data: Any?) = ResultVO().also {
        it.isSuccess = false
        it.status = status
        it.message = message
        it.data = data
    }

    protected fun result(row: Int): ResultVO {
        return if (row <= 0) onFail() else onSuccess()
    }
}
