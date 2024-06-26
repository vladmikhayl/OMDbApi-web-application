package org.hse.template.client.rest.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Информация о фильме/сериале")
data class Movie(
    @JsonProperty("Title")
    @Schema(description = "Название")
    var title: String,

    @JsonProperty("Year")
    @Schema(description = "Год выхода")
    var year: String,

    @JsonProperty("imdbID")
    @Schema(description = "ID на IMDb")
    var imdbID: String,

    @JsonProperty("Type")
    @Schema(description = "Тип (фильм/сериал/эпизод)")
    var type: String,

    @JsonProperty("Poster")
    @Schema(description = "Ссылка на постер")
    var poster: String
) {
    override fun toString(): String {
        return "{\n" +
                "  \"Title\": \"$title\",\n" +
                "  \"Year\": \"$year\",\n" +
                "  \"imdbID\": \"$imdbID\",\n" +
                "  \"Type\": \"$type\",\n" +
                "  \"Poster\": \"$poster\",\n" +
                "}"
    }
}
