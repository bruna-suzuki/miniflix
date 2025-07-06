package com.miniflix.dtos

import java.util.UUID

data class PurchaseDto(
    val userId: UUID,
    val movieId: UUID
)
