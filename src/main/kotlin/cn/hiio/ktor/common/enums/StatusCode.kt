package cn.hiio.ktor.common.enums

enum class StatusCode {
    success(Int.MAX_VALUE, "成功"),
    failed(Int.MIN_VALUE, "请求失败"),
    forbidden(-403, "非法"),
    timeout(-408, "请求超时");

    var code: Int
    var message: String

    constructor(code: Int, message: String) {
        this.code = code
        this.message = message
    }
}