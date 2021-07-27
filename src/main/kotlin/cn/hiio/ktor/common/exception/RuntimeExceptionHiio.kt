package cn.hiio.ktor.common.exception

import cn.hiio.ktor.common.enums.StatusCode

class RuntimeExceptionHiio: BaseRuntimeException {
    lateinit var statusCode: StatusCode

    private constructor(message: String?) : super(message)

    constructor(statusCode: StatusCode, defaultMessage:String?):this(if (defaultMessage!=null&&defaultMessage.length>0) defaultMessage else statusCode.message){
        this.statusCode = statusCode
    }
}