package com.miniflix.services

import com.miniflix.dtos.PurchaseDto
import com.miniflix.repositories.MovieRepository
import com.miniflix.repositories.UserRepository
import org.springframework.stereotype.Service
import kotlin.minus

@Service
class PurchaseService(
    private val userRepository: UserRepository,
    private val movieRepository: MovieRepository,
) {

    fun purchaseMovie(payload: PurchaseDto) {
        val user = userRepository.findById(payload.userId)
            .orElseThrow { Exception("User not found") }
        val movie = movieRepository.findById(payload.movieId)
            .orElseThrow { Exception("Movie not found") }

        if (user.walletAmount > movie.price) {
            user.moviesBought?.add(movie)
            user.walletAmount -= movie.price

            userRepository.save(user)
        } else {
            throw Exception("Insufficient balance.")
        }
    }
}