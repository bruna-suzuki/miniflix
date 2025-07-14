package com.miniflix.services

import com.miniflix.dtos.DirectorDto
import com.miniflix.models.DirectorModel
import com.miniflix.repositories.DirectorRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DirectorService(private val directorRepository: DirectorRepository) {

    fun createDirector(payload: DirectorDto): DirectorModel {
        val director = DirectorModel(name = payload.name)

        directorRepository.save(director)
        return director
    }

    fun deleteDirector(id: UUID) {
        return directorRepository.deleteById(id)
    }

    fun getAllDirector(): List<DirectorModel> {
        return directorRepository.findAll()
    }
}