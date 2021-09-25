package br.com.zup.autores

import br.com.zup.livros.Livro
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
class Autor(
    @field:NotBlank
    val nome: String,
    @field:NotBlank @field:Email
    val email: String,
    @field:NotBlank
    val descricao: String,
    @OneToMany(cascade = [CascadeType.ALL])
    val livros: List<Livro>
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null

    @field:NotNull
    @field:JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    val criadoEm: LocalDate = LocalDate.now()
}