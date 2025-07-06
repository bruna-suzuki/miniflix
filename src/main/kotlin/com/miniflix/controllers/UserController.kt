package com.miniflix.controllers

import com.miniflix.dtos.AddMoneyDto
import com.miniflix.dtos.PurchaseDto
import com.miniflix.dtos.UserDto
import com.miniflix.models.UserModel
import com.miniflix.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/miniflix/user")
class UserController(
    private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody payload: UserDto): ResponseEntity<UserModel> {
        val newUser = userService.createUser(payload)
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser)
    }

    @PostMapping("/purchase")
    fun purchaseMovie(@RequestBody payload: PurchaseDto) {
        userService.purchaseMovie(payload)
    }

    @PostMapping("/addMoney")
    fun addMoney(@RequestBody payload: AddMoneyDto): ResponseEntity<String> {
        val userName = userService.addMoney(payload)
        return ResponseEntity.status(HttpStatus.OK).body("${payload.amount} foi adicionado á ${userName}")
    }
}