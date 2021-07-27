package cn.hiio.ktor.common.utils

import com.alibaba.fastjson.JSON
import cn.hiio.ktor.common.vo.ResultVo


fun res():String{
    return res(null)
}
fun<T> res(data:T?):String{
    return res(data,null)
}
fun<T> res(data:T?,attribute:Map<String,Any>?):String{
    return JSON.toJSONString(ResultVo(data = data,attribute =attribute))
}
fun<T> res(data:T,total:Long):String{
    var attribute = mapOf<String,Any>("total" to total)
    return res(data,attribute)
}

//
//val AUTHED_USER_KEY = "__AUTHED_USER__"
//fun setAuthUser(request: HttpServletRequest, userDO: UserDO){
//    request.setAttribute(AUTHED_USER_KEY,userDO)
//}
//fun getAuthUser(request: HttpServletRequest): UserDO {
//    return request.getAttribute(AUTHED_USER_KEY) as UserDO
//}
//
//
//val ADMIN_AUTHED_USER_KEY = "__ADMIN_AUTHED_USER__"
//fun setAdminAuthUser(request: HttpServletRequest, adminUserVo: AdminUserDO){
//    request.setAttribute(ADMIN_AUTHED_USER_KEY,adminUserVo)
//}
//fun getAdminAuthUser(request: HttpServletRequest):AdminUserDO{
//    return request.getAttribute(ADMIN_AUTHED_USER_KEY) as AdminUserDO
//}
