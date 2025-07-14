package com.miniflix.controllers

import com.miniflix.dtos.AddMoneyDto
import com.miniflix.dtos.PurchaseDto
import com.miniflix.dtos.UserDto
import com.miniflix.models.UserModel
import com.miniflix.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

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

    @DeleteMapping("/delete/{id}")
    fun deleteUser(id: UUID): ResponseEntity<String> {
        userService.deleteUser(id)
        return ResponseEntity.status(HttpStatus.OK).body("User has been deleted.")
    }

    @GetMapping
    fun getAllUser(): ResponseEntity<List<UserModel>> {
        val users = userService.getAllUsers()
        return ResponseEntity.status(HttpStatus.OK).body(users)
    }
}