package moe.awawa.spjam.web.conf

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.context.support.ReloadableResourceBundleMessageSource

@Configuration
open class WebConfig : WebMvcConfigurerAdapter(){
	
	override fun configureContentNegotiation(configurer: ContentNegotiationConfigurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON)
	}
	
	@Bean
	open fun messageSource(): MessageSource {
		val source = ReloadableResourceBundleMessageSource()
		source.setBasenames("classpath:messages", "classpath:errorMessages")
		return source
	}
}