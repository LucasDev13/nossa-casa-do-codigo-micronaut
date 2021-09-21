package br.com.zup.autores

import br.com.zup.livros.Livro
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class Autor(
    val nome: String,
    val email: String,
    val descricao: String,
    @OneToMany
    val livros: List<Livro>
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null

    @field:NotNull
    @field:JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    val criadoEm: LocalDate = LocalDate.now()
}