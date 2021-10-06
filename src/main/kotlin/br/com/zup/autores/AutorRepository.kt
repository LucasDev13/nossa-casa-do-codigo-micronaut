package br.com.zup.autores

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Pageable
import java.util.*

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {
    fun findByEmail(email: String): Optional<Autor>

    fun findByNome(nome: String, pageable: Pageable): List<Autor>

    @Query("SELECT a FROM Autor a WHERE a.email = :email")
    fun buscaEmail(email: String):Optional<Autor>
}