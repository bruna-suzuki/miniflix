package com.miniflix.controllers

import com.miniflix.dtos.MovieDto
import com.miniflix.models.MovieModel
import com.miniflix.services.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/miniflix/movie")
class MovieController(private val movieService: MovieService) {

    @PostMapping
    fun createMovie(@RequestBody payload: MovieDto): ResponseEntity<MovieModel> {
        val movie = movieService.createMovie(payload)
        return ResponseEntity.status(HttpStatus.CREATED).body(movie)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteMovie(@PathVariable id: UUID): ResponseEntity<String> {
        movieService.deleteMovie(id)
        return ResponseEntity.status(HttpStatus.OK).body("Movie has been deleted.")
    }

    @GetMapping
    fun getAllMovies(): ResponseEntity<List<MovieModel>> {
        val movies = movieService.getAllMovie()
        return ResponseEntity.status(HttpStatus.OK).body(movies)
    }


}