package com.miniflix.dtos

import com.miniflix.enums.MovieGenreEnum
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class MovieDto(
    val title: String,
    val releaseDate: LocalDate,
    val directorId: UUID,
    val movieGenre: MovieGenreEnum,
    val reviewComment: String,
    val starReview: Int,
    val price: BigDecimal
)
