package org.hse.template.controller

import org.hse.template.api.MoviesApi
import org.hse.template.client.rest.api.MoviesClient
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class MoviesController(
    private val moviesClient: MoviesClient
) : MoviesApi {
    private val apiKey = "ecdbe056"

    @GetMapping("/search/{title}")
    override fun search(@PathVariable title: String) = moviesClient.search(title, apiKey)

    @GetMapping("/movie/{id}")
    override fun movie(@PathVariable id: String) = moviesClient.movie(id, apiKey)

    @GetMapping("/movies/{title}")
    override fun movies(@PathVariable title: String) = moviesClient.movies(title, apiKey)

    @GetMapping("/year-serial/{title}&{year}")
    override fun serialByYear(
        @PathVariable title: String,
        @PathVariable year: String
    ) = moviesClient.serialByYear(title, year, apiKey)

    @GetMapping("/year-serials/{title}&{year}")
    override fun serialsByYear(
        @PathVariable title: String,
        @PathVariable year: String
    ) = moviesClient.serialsByYear(title, year, apiKey)
}