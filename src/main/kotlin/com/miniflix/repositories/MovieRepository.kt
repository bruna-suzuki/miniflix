package com.miniflix.repositories

import com.miniflix.models.MovieModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MovieRepository : JpaRepository<MovieModel, UUID> {
}