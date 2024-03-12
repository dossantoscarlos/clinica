package br.dossantoscarlos.clinica.mvc

import br.dossantoscarlos.clinica.mvc.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepositoryImpl : JpaRepository<User, UUID> {

    fun findByEmail(email: String): User
}