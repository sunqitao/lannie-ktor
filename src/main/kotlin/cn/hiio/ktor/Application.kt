package cn.hiio.ktor

import cn.hiio.ktor.routes.apiRoute
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        apiRoute()
    }.start(wait = true)
}
