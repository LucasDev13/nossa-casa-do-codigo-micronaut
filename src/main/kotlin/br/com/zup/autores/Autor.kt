package br.com.zup.autores

import br.com.zup.livros.Livro

class Autor(
    val nome: String,
    val email: String,
    val descricao: String,
    val livros: List<Livro>
) {
}