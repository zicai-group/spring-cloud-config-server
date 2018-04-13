package io.gitee.zicai.core.feign;

import io.gitee.zicai.core.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IPublishedFeign {

    String PREFIX = "/published";

    @GetMapping(PREFIX + "save/{appName}/{profile}")
    ResultVO publishedSave(@PathVariable("appName") String appName, @PathVariable("profile") String profile);

    @GetMapping(PREFIX + "save/{appId}")
    ResultVO publishedSave(@PathVariable("appId") Long appId);

    @GetMapping(PREFIX + "last/{appName}/{profile}")
    ResultVO publishedLast(@PathVariable("appName") String appName, @PathVariable("profile") String profile);

    @GetMapping(PREFIX + "last/{appId}")
    ResultVO publishedLast(@PathVariable("appId") Long appId);
}
