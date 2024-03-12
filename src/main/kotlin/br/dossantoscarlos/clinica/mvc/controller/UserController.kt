package br.dossantoscarlos.clinica.mvc.controller

import br.dossantoscarlos.clinica.mvc.model.User
import br.dossantoscarlos.clinica.mvc.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {

    @GetMapping("api/users")
    fun getUsers(): List<User> {
        return this.userService.listUsers()
    }

    @GetMapping("api/user/{email}")
    fun showUser(@PathVariable("email") email: String): User {
        return userService.findByEmail(email)
    }

    @PostMapping("api/user")
    fun createUser(@RequestBody user: User): User {
        return userService.createUser(user)
    }
}
