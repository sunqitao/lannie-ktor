package cn.hiio.ktor.common.intercept

import cn.hiio.ktor.common.enums.StatusCode
import cn.hiio.ktor.common.exception.RuntimeExceptionHiio
import cn.hiio.ktor.common.utils.res
import cn.hiio.ktor.common.vo.ResultVo
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

object ServerIntercept{

    fun Route.tokenCheck(role: String = "default", build: Route.() -> Unit): Route {
        val route = createChild(TokenRouteSelector(role))
        route.intercept(ApplicationCallPipeline.Features) {
            val begTime = System.currentTimeMillis()
            val token = call.request.header("TOKEN")
            try {
                token?.let {
                    //可以在此处做传入token 的业务
                    proceed()
                } ?: let {
                    //在此处做没有传入token 的业务
                    finish()
                }
            } catch (e: Exception) {
                processException(e, call)
            }
            call.application.environment.log.info("request uri is ${call.request.path()},response use [${System.currentTimeMillis()-begTime}ms]")
        }
        route.build()
        return route
    }

    fun Route.adminTokenCheck(role: String = "default", build: Route.() -> Unit): Route {
        val route = createChild(TokenRouteSelector(role))
        route.intercept(ApplicationCallPipeline.Features) {
            val begTime = System.currentTimeMillis()
            val token = call.request.header("ADMINTOKEN")
            try {
                token?.let {
                    //可以在此处做传入token 的业务
                    proceed()
                } ?: let {
                    //在此处做没有传入token 的业务
                    finish()
                }
            } catch (e: Exception) {
                processException(e, call)
            }
            call.application.environment.log.info("request uri is ${call.request.path()},response use [${System.currentTimeMillis()-begTime}ms]")
        }
        route.build()
        return route
    }

    fun Route.normalCheck(role: String = "default", build: Route.() -> Unit): Route {
        val route = createChild(TokenRouteSelector(role))
        route.intercept(ApplicationCallPipeline.Features) {
            try {
                val begTime = System.currentTimeMillis()
                proceed()
                call.application.environment.log.info("request uri is ${call.request.path()},response use [${System.currentTimeMillis()-begTime}ms]")
            } catch (e: Exception) {
                processException(e, call)
            }
        }
        route.build()
        return route
    }

    private suspend fun processException(e: Exception, call: ApplicationCall) {
        if (e is RuntimeExceptionHiio) {
            call.respond(
                res(
                    ResultVo(
                        e.statusCode.code, if (e.message != null) {
                            e.message!!
                        } else {
                            e.statusCode.message
                        }, null
                    )
                )
            )
        } else {
            call.respond(res(ResultVo(StatusCode.failed.code, StatusCode.failed.message, null)))
        }
    }
}
