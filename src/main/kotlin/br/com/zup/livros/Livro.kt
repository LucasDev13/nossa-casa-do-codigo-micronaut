package br.com.zup.livros

import java.time.LocalDate

data class Livro(
    val titulo: String,
    val isbn: String
) {
    val publicadoEm: LocalDate = LocalDate.now()
}