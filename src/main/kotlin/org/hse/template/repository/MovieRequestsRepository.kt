package org.hse.template.repository

import org.hse.template.requests.MovieRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MovieRequestsRepository : JpaRepository<MovieRequest, Long> {

    fun findMovieRequestByTypeAndParam(type: Int, param: String): Optional<MovieRequest>

}