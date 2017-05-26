package moe.awawa.spjam.web.api

import moe.awawa.spjam.web.model.response.BaseResponse
import moe.awawa.spjam.web.model.response.ValidResponse
import moe.awawa.spjam.web.service.CandidateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Controller class related to candidates' information.
 *
 * @constructor Creates a controller instance.
 * Normally you don't have to be conscious as the framework runs.
**/
@RestController
@RequestMapping("/candidate")
open class CandidateController {
	
	/**
	 * Service for candidates' information.
	**/
	@Autowired
	lateinit var candidateService: CandidateService
	
	/**
	 * Lists all available candidates.
	 * @return
	**/
	@RequestMapping(value="/list", method=arrayOf(RequestMethod.GET))
	fun list(): ResponseEntity<BaseResponse> {
		return ResponseEntity(ValidResponse(candidateService.listCandidates()), HttpStatus.OK)	
	}
}