package org.hse.template.service

import org.hse.template.client.rest.api.MoviesClient
import org.hse.template.client.rest.model.Movie
import org.hse.template.client.rest.model.MoviesList
import org.hse.template.repository.MovieRequestsRepository
import org.hse.template.requests.MovieRequest
import org.springframework.stereotype.Service

@Service
class MoviesService(
    private val moviesClient: MoviesClient,
    private val movieRequestsRepository: MovieRequestsRepository
) {
    private val apiKey = "ecdbe056"

    fun search(title: String) : Any? {
        val optionalMovie = movieRequestsRepository.findMovieRequestByTypeAndParam(1, title)
        if (optionalMovie.isPresent) {
            return optionalMovie.get().requestResponse
        }
        val movie = moviesClient.search(title, apiKey)
        movieRequestsRepository.save(MovieRequest(1, title, movie))
        return movie
    }

    fun movie(id: String) : Any? {
        val optionalMovie = movieRequestsRepository.findMovieRequestByTypeAndParam(2, id)
        if (optionalMovie.isPresent) {
            return optionalMovie.get().requestResponse
        }
        val movie = moviesClient.movie(id, apiKey)
        movieRequestsRepository.save(MovieRequest(2, id, movie))
        return movie
    }

    fun movies(title: String) : Any? {
        val optionalMovies = movieRequestsRepository.findMovieRequestByTypeAndParam(3, title)
        if (optionalMovies.isPresent) {
            return optionalMovies.get().requestResponse
        }
        val movies = moviesClient.movies(title, apiKey)
        movieRequestsRepository.save(MovieRequest(3, title, movies))
        return movies
    }

    fun serialByYear(title: String, year: String) : Any? {
        val optionalMovie = movieRequestsRepository
            .findMovieRequestByTypeAndParam(4, "$title&$year")
        if (optionalMovie.isPresent) {
            return optionalMovie.get().requestResponse
        }
        val movie = moviesClient.serialByYear(title, year, apiKey)
        movieRequestsRepository.save(MovieRequest(4, "$title&$year", movie))
        return movie
    }

    fun serialsByYear(title: String, year: String) : Any? {
        val optionalMovies = movieRequestsRepository.findMovieRequestByTypeAndParam(5, "$title&$year")
        if (optionalMovies.isPresent) {
            return optionalMovies.get().requestResponse
        }
        val movies = moviesClient.serialsByYear(title, year, apiKey)
        movieRequestsRepository.save(MovieRequest(5, "$title&$year", movies))
        return movies
    }

}