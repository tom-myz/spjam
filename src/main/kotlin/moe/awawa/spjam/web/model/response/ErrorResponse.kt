package moe.awawa.spjam.web.model.response

class ErrorResponse(message: String, result: Any?) : BaseResponse(ResponseStatus.NG, result, message) {
}