package cn.hiio.ktor.common.intercept

import io.ktor.routing.*

class TokenRouteSelector(val role: String) : RouteSelector(RouteSelectorEvaluation.qualityConstant) {
    override fun evaluate(context: RoutingResolveContext, segmentIndex: Int): RouteSelectorEvaluation {
        return RouteSelectorEvaluation.Constant
    }
    override fun toString(): String = "(tokenCheck ${role})"
}