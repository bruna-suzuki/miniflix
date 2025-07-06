package com.miniflix.repositories

import com.miniflix.models.ReviewModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ReviewRepository : JpaRepository<ReviewModel, UUID> {
}