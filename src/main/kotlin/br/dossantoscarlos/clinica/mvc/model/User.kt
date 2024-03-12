package br.dossantoscarlos.clinica.mvc.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "usuarios")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private val id: UUID?,
    private val username: String,
    private val email: String,
    private val dataNascimento: String) {

    fun getName() : String {
        return this.username
    }

    fun getEmail() : String {
        return this.email
    }

}