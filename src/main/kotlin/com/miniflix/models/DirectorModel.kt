package com.miniflix.models

import com.fasterxml.jackson.annotation.JsonProperty
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "director")
    val movies: List<MovieModel>? = null,
)
