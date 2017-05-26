package moe.awawa.spjam.web.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

/**
 * 
**/
@Configuration
@EnableWebSecurity
open class SecurityConfig : WebSecurityConfigurerAdapter() {

	override fun configure(http: HttpSecurity) {
		http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated()
		http.csrf().disable()
	}
	
	@Bean
	override fun userDetailsService(): UserDetailsService {
		val manager = InMemoryUserDetailsManager()
		manager.createUser(User.withUsername("admin").password("password").roles("ADMIN").build())
		manager.createUser(User.withUsername("system").password("password").roles("ACTUATOR").build())
		return manager
	}
}