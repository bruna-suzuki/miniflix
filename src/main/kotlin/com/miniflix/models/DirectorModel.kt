package com.miniflix.models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tb_director")
data class DirectorModel(

    @Id
    val id: UUID = UUID.randomUUID(),

    val name: String,

    @OneToMany(mappedBy = "director")
    val movies: List<MovieModel>? = null,
)
