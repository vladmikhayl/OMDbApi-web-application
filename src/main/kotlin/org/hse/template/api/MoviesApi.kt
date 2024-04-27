package org.hse.template.api

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.hse.template.client.rest.model.Movie
import org.hse.template.client.rest.model.MoviesList

interface MoviesApi {

    @Tag(name = "Получить фильм/сериал по названию")
    @ApiResponses(
        ApiResponse(
            description = "Успешный ответ",
            responseCode = "200"
        )
    )
    fun search(
        @Schema(
            description = "Название",
            defaultValue = "The Shawshank Redemption"
        )
        title: String
    ): Movie

    @Tag(name = "Получить фильм/сериал по ID")
    @ApiResponses(
        ApiResponse(
            description = "Успешный ответ",
            responseCode = "200"
        )
    )
    fun movie(
        @Schema(
            description = "ID",
            defaultValue = "tt15398776"
        )
        id: String
    ): Movie

    @Tag(name = "Получить список фильмов/сериалов по названию")
    @ApiResponses(
        ApiResponse(
            description = "Успешный ответ",
            responseCode = "200"
        )
    )
    fun movies(
        @Schema(
            description = "Название",
            defaultValue = "Terminator"
        )
        title: String
    ): MoviesList

    @Tag(name = "Получить сериал по названию и году выхода")
    @ApiResponses(
        ApiResponse(
            description = "Успешный ответ",
            responseCode = "200"
        )
    )
    fun serialByYear(
        @Schema(
            description = "Название",
            defaultValue = "Friends"
        )
        title: String,
        @Schema(
            description = "Год выхода",
            defaultValue = "1994"
        )
        year: String
    ): Movie

    @Tag(name = "Получить список сериалов по названию и году выхода")
    @ApiResponses(
        ApiResponse(
            description = "Успешный ответ",
            responseCode = "200"
        )
    )
    fun serialsByYear(
        @Schema(
            description = "Название",
            defaultValue = "Friends"
        )
        title: String,
        @Schema(
            description = "Год выхода",
            defaultValue = "1994"
        )
        year: String
    ): MoviesList

}