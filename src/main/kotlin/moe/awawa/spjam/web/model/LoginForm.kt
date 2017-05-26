package moe.awawa.spjam.web.model

data class LoginForm(val userId: String, val password: String) {
	constructor() : this("", "")
}