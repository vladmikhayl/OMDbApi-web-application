package org.hse.template.requests

import jakarta.persistence.*
import jakarta.validation.constraints.Size
import org.hse.template.client.rest.model.Movie
import org.hse.template.client.rest.model.MoviesList

@Table
@Entity
data class MovieRequest(
    @Id
    @SequenceGenerator(
        name = "movie_request_sequence",
        sequenceName = "movie_request_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "movie_request_sequence"
    )
    val id: Long? = null,

    val type: Int? = null,

    val param: String? = null,

    @Column(columnDefinition="TEXT")
    val requestResponse: String? = null
) {
    constructor(
        requestType: Int,
        param: String,
        movie: Movie
    ) : this(
        0,
        requestType,
        param,
        movie.toString()
    )

    constructor(
        requestType: Int,
        param: String,
        moviesList: MoviesList
    ) : this(
        0,
        requestType,
        param,
        moviesList.toString()
    )
}
