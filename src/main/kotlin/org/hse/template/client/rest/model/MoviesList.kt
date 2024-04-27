package org.hse.template.client.rest.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

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
)
