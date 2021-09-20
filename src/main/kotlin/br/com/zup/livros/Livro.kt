package br.com.zup.livros

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
data class Livro(
    @field:NotBlank val titulo: String,
    @field:NotBlank val isbn: String
) {
    @field:NotNull @field:JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    val publicadoEm: LocalDate = LocalDate.now()
}