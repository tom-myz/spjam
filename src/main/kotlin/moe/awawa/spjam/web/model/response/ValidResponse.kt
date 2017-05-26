package moe.awawa.spjam.web.model.response

open class ValidResponse(result: Any?, message: String?) : BaseResponse(ResponseStatus.OK, result, message) {
	constructor(result: Any?) : this(result, null)
}