package io.gitee.zicai.core.feign;

import io.gitee.zicai.core.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IAppFeign {

    String PREFIX = "/app";

    @GetMapping(PREFIX + "/get/{appName}/{profile}")
    ResultVO appGet(@PathVariable("appName") String appName, @PathVariable("profile") String profile);

    @GetMapping(PREFIX + "/add/{appName}/{profile}")
    ResultVO appAdd(@PathVariable("appName") String appName, @PathVariable("profile") String profile);

    @GetMapping(PREFIX + "/del/{id}")
    ResultVO appDel(@PathVariable("id") Long id);

    @GetMapping(PREFIX + "/page/{index}/{size}")
    ResultVO appPage(@PathVariable("index") Integer index, @PathVariable("size") Integer size);
}
