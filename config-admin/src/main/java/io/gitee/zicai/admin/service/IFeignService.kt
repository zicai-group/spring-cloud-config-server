package io.gitee.zicai.admin.service

import io.gitee.zicai.core.feign.IAppFeign
import io.gitee.zicai.core.feign.IAppPropsFeign
import io.gitee.zicai.core.feign.IPublishedFeign
import org.springframework.cloud.netflix.feign.FeignClient

@FeignClient("zicai-config-server")
interface IFeignService : IAppFeign, IAppPropsFeign, IPublishedFeign