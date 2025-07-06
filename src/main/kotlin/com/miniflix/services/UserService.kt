package com.miniflix.services

import com.miniflix.dtos.AddMoneyDto
import com.miniflix.dtos.PurchaseDto
import com.miniflix.dtos.UserDto
import com.miniflix.models.UserModel
import com.miniflix.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val purchaseService: PurchaseService,
) {

    fun createUser(payload: UserDto): UserModel {
        val newUser = UserModel(
            fullName = payload.fullName,
            email = payload.email,
            age = payload.age,
        )

        userRepository.save(newUser)
        return newUser
    }

    fun purchaseMovie(payload: PurchaseDto) {
        purchaseService.purchaseMovie(payload)
    }

    fun addMoney(payload: AddMoneyDto): String {
        val user = userRepository.findById(payload.userId)
            .orElseThrow { Exception("User not found") }

        user.walletAmount += payload.amount
        userRepository.save(user)

        return user.fullName
    }
}