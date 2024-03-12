package br.dossantoscarlos.clinica.mvc.services

import br.dossantoscarlos.clinica.mvc.UserRepositoryImpl
import br.dossantoscarlos.clinica.mvc.model.User
import org.springframework.http.ResponseEntity

import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
class UserService (private val userRepository: UserRepositoryImpl)  {

    fun listUsers() : List<User> {
        return userRepository.findAll()
    }

    fun createUser (user: User) : User {
        return userRepository.save(user)
    }

    fun findByEmail(email: String): User {
        return userRepository.findByEmail(email)
    }
}