package cn.hiio.ktor.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import cn.hiio.ktor.common.intercept.ServerIntercept.normalCheck
import cn.hiio.ktor.common.utils.res

fun Application.configureSerialization() {
    install(CORS){
        anyHost()
        header("TOKEN")
        header("ADMINTOKEN")
    }
    routing {
        normalCheck {
            get("/json") {
//                AssertUtil.isFalse(true,StatusCode.failed,"异常")
                call.respond(res(mapOf("hello" to "world")))
            }
        }

    }
}
