package com.miniflix.models

import com.miniflix.enums.MovieGenreEnum
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "tb_movie")
data class MovieModel(

    @Id
    val id: UUID = UUID.randomUUID(),

    val title: String,

    val releaseDate: LocalDate,

    @ManyToOne
    @JoinColumn(name = "director_id")
    val director: DirectorModel,

    @Enumerated(EnumType.STRING)
    val movieGenre: MovieGenreEnum,

    @OneToMany(mappedBy = "movie")
    val review: MutableList<ReviewModel>? = null,

    val price: BigDecimal,
)
