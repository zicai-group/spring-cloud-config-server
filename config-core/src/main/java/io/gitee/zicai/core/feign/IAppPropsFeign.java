package io.gitee.zicai.core.feign;

import io.gitee.zicai.core.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface IAppPropsFeign {

    String PREFIX = "/props";

    @GetMapping(PREFIX + "/get/{appName}/{profile}")
    ResultVO propsGet(@PathVariable("appName") String appName, @PathVariable("profile") String profile);

    @GetMapping(PREFIX + "/add/{appId}")
    ResultVO propsAdd(@PathVariable("appId") Long appId, @RequestParam("k") String k, @RequestParam("v") String v);

    @GetMapping(PREFIX + "/del/{id}")
    ResultVO propsDel(@PathVariable("id") Long id);

    @GetMapping(PREFIX + "/page/{index}/{size}")
    ResultVO propsPage(@PathVariable("index") Integer index, @PathVariable("size") Integer size);
}
