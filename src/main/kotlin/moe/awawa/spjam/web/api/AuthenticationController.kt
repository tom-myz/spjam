package moe.awawa.spjam.web.api

import moe.awawa.spjam.web.model.LoginForm
import moe.awawa.spjam.web.model.response.BaseResponse
import moe.awawa.spjam.web.model.response.ErrorCode
import moe.awawa.spjam.web.model.response.ValidResponse
import moe.awawa.spjam.web.service.AuthenticationService
import moe.awawa.spjam.web.service.ResponseFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

/**
 * Controller class related to user authentication.
 *
 * @constructor Creates a controller instance.
 * Normally you don't have to be conscious as the framework runs.
**/
@RestController
open class AuthenticationController {
	
	/**
	 * Service for authentication and session management.
	**/
	@Autowired
	lateinit var authenticationService: AuthenticationService
	
	/**
	 * API response factory.
	**/
	@Autowired
	lateinit var responseFactory: ResponseFactory

	/**
	 * Tries to login with user ID and password.
	 * @param loginForm
	 * @return Authentication information. if authentication fails, it returns 401:UNAUTHORIZED.
	**/
	@RequestMapping(value = "login", method = arrayOf(RequestMethod.POST), consumes = arrayOf("application/json"))
	open fun login(@RequestBody loginForm: LoginForm): ResponseEntity<BaseResponse> {
		val authResult = authenticationService.login(loginForm.userId, loginForm.password)
		return if (authResult != null) {
			ResponseEntity(ValidResponse(authResult), HttpStatus.OK)
		} else {
			ResponseEntity(responseFactory.errorResponse(ErrorCode.AuthenticationFailure), HttpStatus.UNAUTHORIZED)
		}
	}
	
	/**
	 * Log out the user who sent the request.
	 * @param request
	 * @return
	**/
	@RequestMapping(value = "logout", method = arrayOf(RequestMethod.POST))
	open fun logout(request: HttpServletRequest): ResponseEntity<BaseResponse> {
		request.logout()
		return ResponseEntity(ValidResponse(null), HttpStatus.OK)
	}
}