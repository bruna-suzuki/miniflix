package com.miniflix.controllers

import com.miniflix.dtos.MovieDto
import com.miniflix.models.MovieModel
import com.miniflix.services.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/miniflix/movie")
class MovieController(private val movieService: MovieService) {

    @PostMapping
    fun createMovie(@RequestBody payload: MovieDto): ResponseEntity<MovieModel> {
        val movie = movieService.createMovie(payload)
        return ResponseEntity.status(HttpStatus.CREATED).body(movie)
    }
}