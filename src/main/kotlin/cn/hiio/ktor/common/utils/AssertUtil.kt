package cn.hiio.ktor.common.utils

import cn.hiio.ktor.common.enums.StatusCode
import cn.hiio.ktor.common.exception.RuntimeExceptionHiio


class AssertUtil {
    companion object{
        fun fail(statusCode: StatusCode, defaultMessage:String?){
            throw RuntimeExceptionHiio(statusCode,defaultMessage)
        }
        fun hasLengthByTrim(text:String,statusCode: StatusCode){
            if(text.trim().length == 0){
                fail(statusCode,null)
            }
        }
        fun hasLengthByTrim(text:String, statusCode: StatusCode, defaultMessage: String){
            if(text.trim().length == 0){
                fail(statusCode,defaultMessage)
            }
        }
        fun isNotNull(any: Any?,statusCode: StatusCode){
            if(any == null){
                fail(statusCode,null)
            }
        }
        fun isNotNull(any: Any?, statusCode: StatusCode, defaultMessage: String){
            if(any == null){
                fail(statusCode,defaultMessage)
            }
        }
        fun hasLength(text:String?,statusCode: StatusCode){
            if(text==null || text.length < 1){
                fail(statusCode,null)
            }
        }
        fun hasLength(text:String?, statusCode: StatusCode, defaultMessage: String){
            if(text==null || text.length < 1){
                fail(statusCode,defaultMessage)
            }
        }


        fun isTrue(expression:Boolean,statusCode: StatusCode){
            if(!expression){
                fail(statusCode,null)
            }
        }
        fun isTrue(expression:Boolean, statusCode: StatusCode, defaultMessage: String){
            if(!expression){
                fail(statusCode,defaultMessage)
            }
        }

        fun isFalse(expression:Boolean,statusCode: StatusCode){
            isTrue(!expression,statusCode)
        }
        fun isFalse(expression:Boolean, statusCode: StatusCode, defaultMessage: String){
            isTrue(!expression,statusCode,defaultMessage)
        }

        fun isNull(any: Any,statusCode: StatusCode){
            if(any != null){
                fail(statusCode,null)
            }
        }
        fun isNull(any: Any, statusCode: StatusCode, defaultMessage: String){
            if(any != null){
                fail(statusCode,defaultMessage)
            }
        }
        fun hasSize(any: Collection<Any>, statusCode: StatusCode, defaultMessage: String){
            if(any?.isNotEmpty()){
            }else{
                fail(statusCode,defaultMessage)
            }
        }
    }
}