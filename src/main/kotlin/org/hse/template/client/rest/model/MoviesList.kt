package org.hse.template.client.rest.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Информация о списке фильмов/сериалов")
data class MoviesList(
    @JsonProperty("Search")
    @Schema(description = "Список найденных фильмов/сериалов")
    var search: List<Movie>,

    @JsonProperty("totalResults")
    @Schema(description = "Всего результатов")
    var totalResults: String,

    @JsonProperty("Response")
    @Schema(description = "Статус ответа")
    var response: String
) {
    override fun toString(): String {
        var result = "{\n" +
                "  \"Search\": ["
        for (movie in search) {
            val movieString = movie.toString()
            for (string in movieString.split('\n')) {
                result += "\n    $string"
            }
            result += ","
        }
        result += "\n  ],\n" +
                "  \"totalResults\": \"$totalResults\",\n" +
                "  \"Response\": \"$response\"\n" +
                "}"
        return result
    }
}
