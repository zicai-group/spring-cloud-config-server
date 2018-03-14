package io.gite.zicai.domain

import java.util.*

data class Published(
        var id: Int = 0,
        var appName: String,
        var publishTime: Date = Date()
)