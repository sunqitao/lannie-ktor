package cn.hiio.ktor.test.vo

import cn.hiio.ktor.common.vo.BaseModel
import kotlinx.serialization.Serializable

@Serializable
class TestTempVo:BaseModel() {
    var name:String?=null
    var age:Int?=null
}