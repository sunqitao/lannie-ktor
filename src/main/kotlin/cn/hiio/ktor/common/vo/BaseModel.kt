package cn.hiio.ktor.common.vo

import org.bson.codecs.pojo.annotations.BsonId
import java.util.*

abstract class BaseModel(){
    @BsonId
    var id: String? = null
    var updated: Date? = null
    var created: Date? = null
    var deleted: Boolean? = null
}