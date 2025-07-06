package com.miniflix.dtos

import java.math.BigDecimal
import java.util.UUID

data class AddMoneyDto(
    val userId: UUID,
    val amount: BigDecimal,
)
