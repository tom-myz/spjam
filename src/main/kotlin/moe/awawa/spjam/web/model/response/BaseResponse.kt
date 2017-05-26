package moe.awawa.spjam.web.model.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
open class BaseResponse(val status: ResponseStatus, val result: Any?, val message: String?) {
}