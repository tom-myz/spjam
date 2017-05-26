package moe.awawa.spjam.web.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.stereotype.Service
import org.springframework.security.core.context.SecurityContextHolder

@Service
open class AuthenticationService {

	@Autowired
	protected lateinit var authManager: AuthenticationManager

	fun login(userName: String, password: String): Authentication? {
		return try {
			val authResult = authManager.authenticate(UsernamePasswordAuthenticationToken(userName, password))
			SecurityContextHolder.getContext().setAuthentication(authResult)
			authResult
		} catch(e: AuthenticationException) {
			null
		}
	}
}