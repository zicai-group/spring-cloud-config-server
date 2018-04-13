package io.gitee.zicai.core.common;

import io.gitee.zicai.core.vo.ResultVO;

public abstract class BaseController {

    protected ResultVO onSuccess() {
        return onSuccess("操作成功!", null);
    }

    protected ResultVO onSuccess(String message) {
        return onSuccess(message, null);
    }

    protected ResultVO onSuccess(Object data) {
        return onSuccess(null, data);
    }

    protected ResultVO onSuccess(String message, Object data) {
        return onSuccess(message, 1, data);
    }

    protected ResultVO onSuccess(String message, int status, Object data) {
        ResultVO vo = new ResultVO();
        vo.setSuccess(true);
        vo.setStatus(status);
        vo.setMessage(message);
        vo.setData(data);
        return vo;
    }

    protected ResultVO onFail() {
        return onFail("操作失败!", null);
    }

    protected ResultVO onFail(String message) {
        return onFail(message, null);
    }

    protected ResultVO onFail(Object data) {
        return onFail(null, data);
    }

    protected ResultVO onFail(String message, Object data) {
        return onFail(message, 0, data);
    }

    protected ResultVO onFail(String message, int status, Object data) {
        ResultVO vo = new ResultVO();
        vo.setSuccess(false);
        vo.setStatus(status);
        vo.setMessage(message);
        vo.setData(data);
        return vo;
    }

    protected ResultVO result(int row) {
        return row <= 0 ? onFail() : onSuccess();
    }
}
