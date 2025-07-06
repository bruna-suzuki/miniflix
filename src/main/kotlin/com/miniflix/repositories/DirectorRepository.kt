package com.miniflix.repositories

import com.miniflix.models.DirectorModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface DirectorRepository : JpaRepository<DirectorModel, UUID> {
}