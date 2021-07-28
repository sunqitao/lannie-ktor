package cn.hiio.ktor.routes

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import cn.hiio.ktor.common.intercept.ServerIntercept.normalCheck
import cn.hiio.ktor.common.utils.res
import cn.hiio.ktor.test.service.TestService
import org.litote.kmongo.KMongo

fun Application.apiRoute() {
    install(CORS){
        anyHost()
        header("TOKEN")
        header("ADMINTOKEN")
    }

    routing {
        normalCheck {
            get("/json") {
//                AssertUtil.isFalse(true,StatusCode.failed,"异常")
                TestService.saveTempUser("张三",19)
                call.respond(res(mapOf("hello" to "world")))
            }
        }

    }
}
