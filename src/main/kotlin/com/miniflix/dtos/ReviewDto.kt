package com.miniflix.dtos

import com.miniflix.models.MovieModel

data class ReviewDto(
    val movie: MovieModel,
    val comment: String,
    val star: Int
)
