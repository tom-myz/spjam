package moe.awawa.spjam.web.service

import moe.awawa.spjam.web.model.Candidate
import org.springframework.stereotype.Service

@Service
open class CandidateService {
	
	fun listCandidates(): List<Candidate> {
		return listOf(Candidate("牛込りみ"), Candidate("氷川紗夜"))
	}
}