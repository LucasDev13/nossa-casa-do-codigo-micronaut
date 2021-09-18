package br.com.zup.livros

import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.constraints.NotBlank

@Introspected
data class Livro(
    @field:NotBlank val titulo: String,
    @field:NotBlank val isbn: String
) {
    val publicadoEm: LocalDate = LocalDate.now()
}