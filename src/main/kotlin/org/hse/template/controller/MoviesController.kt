package org.hse.template.controller

import org.hse.template.api.MoviesApi
import org.hse.template.client.rest.api.MoviesClient
import org.hse.template.service.MoviesService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class MoviesController(
    private val moviesService: MoviesService
) : MoviesApi {

    @GetMapping("/search/{title}")
    override fun search(@PathVariable title: String) = moviesService.search(title)

    @GetMapping("/movie/{id}")
    override fun movie(@PathVariable id: String) = moviesService.movie(id)

    @GetMapping("/movies/{title}")
    override fun movies(@PathVariable title: String) = moviesService.movies(title)

    @GetMapping("/year-serial/{title}&{year}")
    override fun serialByYear(
        @PathVariable title: String,
        @PathVariable year: String
    ) = moviesService.serialByYear(title, year)

    @GetMapping("/year-serials/{title}&{year}")
    override fun serialsByYear(
        @PathVariable title: String,
        @PathVariable year: String
    ) = moviesService.serialsByYear(title, year)

}