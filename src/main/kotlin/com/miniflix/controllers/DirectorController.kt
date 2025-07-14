package com.miniflix.controllers

import com.miniflix.dtos.DirectorDto
import com.miniflix.models.DirectorModel
import com.miniflix.services.DirectorService
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
@RequestMapping("/miniflix/director")
class DirectorController(private val directorService: DirectorService) {

    @PostMapping
    fun createDirector(@RequestBody payload: DirectorDto): ResponseEntity<DirectorModel> {
        val director = directorService.createDirector(payload)
        return ResponseEntity.status(HttpStatus.CREATED).body(director)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteDirector(@PathVariable id: UUID): ResponseEntity<String> {
        val director = directorService.deleteDirector(id)
        return ResponseEntity.status(HttpStatus.OK).body("Director has been deleted.")
    }

    @GetMapping
    fun getAllDirectors(): ResponseEntity<List<DirectorModel>> {
        val directors = directorService.getAllDirector()
        return ResponseEntity.status(HttpStatus.OK).body(directors)
    }
}