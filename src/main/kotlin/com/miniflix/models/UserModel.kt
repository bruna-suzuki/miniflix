package com.miniflix.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.Email
import org.hibernate.validator.constraints.Range
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "tb_user")
data class UserModel(

    @Id
    val id: UUID = UUID.randomUUID(),

    val fullName: String,

    @Email
    @Column(unique = true)
    val email: String,

    @Range(min = 12, max = 120, message = "Enter a valid age (between 12 and 120)")
    val age: Int,

    @ManyToMany
    @JoinTable(
        name = "tb_user_movies",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "movie_id")]
    )
    val moviesBought: MutableList<MovieModel>? = null,

    var walletAmount: BigDecimal = BigDecimal(0)

)
