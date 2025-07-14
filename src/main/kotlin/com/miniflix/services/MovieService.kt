package com.miniflix.services

import com.miniflix.dtos.MovieDto
import com.miniflix.models.MovieModel
import com.miniflix.models.ReviewModel
import com.miniflix.repositories.DirectorRepository
import com.miniflix.repositories.MovieRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MovieService(
    private val directorRepository: DirectorRepository,
    private val movieRepository: MovieRepository) {

    fun createMovie(payload: MovieDto): MovieModel {

        val director = directorRepository.findById(payload.directorId)
            .orElseThrow { Exception("Director not found.") }

        val newMovie = MovieModel(
            title = payload.title,
            releaseDate = payload.releaseDate,
            director = director,
            movieGenre = payload.movieGenre,
            price = payload.price
        )

        val newReview = ReviewModel(
            movie = newMovie,
            comment = payload.reviewComment,
            stars = payload.starReview
        )

        newMovie.review?.add(newReview)
        val savedMovie = movieRepository.save(newMovie)
        return savedMovie
    }

    fun deleteMovie(id: UUID) {
        movieRepository.deleteById(id)
    }

    fun getAllMovie(): List<MovieModel>{
        return movieRepository.findAll()
    }
}