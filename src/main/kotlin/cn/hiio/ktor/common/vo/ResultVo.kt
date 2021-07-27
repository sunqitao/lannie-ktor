package cn.hiio.ktor.common.vo

import kotlinx.serialization.Serializable

data class ResultVo<T>(var code:Int = Int.MAX_VALUE, var message:String = "成功", var data: T?,var attribute:Map<String,Any>?=null ){
    companion object {
        private const  val serialVersionUID = -23941L
    }

}