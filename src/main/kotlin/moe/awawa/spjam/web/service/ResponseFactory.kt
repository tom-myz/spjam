package moe.awawa.spjam.web.service

import moe.awawa.spjam.web.model.response.ErrorCode
import moe.awawa.spjam.web.model.response.ErrorResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import java.util.Locale

const val errorMessagePrefix: String = "error.code."

/**
 * A factory of [moe.awawa.spjam.web.model.response.BaseResponse] and it's child classes.
**/
@Service
open class ResponseFactory {
	
	/**
	 * Injected MessageSource.
	 * Bean configuration on [moe.awawa.spjam.web.conf.WebConfig].
	**/
	@Autowired
	lateinit var messageSource: MessageSource
	
	/**
	 * Creates new instance of [moe.awawa.spjam.web.model.response.ErrorResponse].
	 *
	 * @param errorCode
	 * @param body 
	 * @return
	 * @throws NoSuchMessageException
	 * 
	 **/
	fun errorResponse(errorCode: ErrorCode, body: Any? = null): ErrorResponse {
		return ErrorResponse(
				messageSource.getMessage(
						errorMessagePrefix + errorCode,
						arrayOf(),
						Locale.getDefault()), body)
	}
}