package org.hse.template.client.rest.api

import org.hse.template.client.rest.model.Movie
import org.hse.template.client.rest.model.MoviesList
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "movies-info")
interface MoviesClient {

    @GetMapping
    fun search(
        @RequestParam("t") title: String,
        @RequestParam("apikey") apiKey: String
    ): Movie

    @GetMapping
    fun movie(
        @RequestParam("i") id: String,
        @RequestParam("apikey") apiKey: String
    ): Movie

    @GetMapping
    fun movies(
        @RequestParam("s") title: String,
        @RequestParam("apikey") apiKey: String
    ): MoviesList

    @GetMapping
    fun serialByYear(
        @RequestParam("t") title: String,
        @RequestParam("y") year: String,
        @RequestParam("apikey") apiKey: String,
        @RequestParam("type") type: String = "series"
    ): Movie

    @GetMapping
    fun serialsByYear(
        @RequestParam("s") title: String,
        @RequestParam("y") year: String,
        @RequestParam("apikey") apiKey: String,
        @RequestParam("type") type: String = "series"
    ): MoviesList

}
