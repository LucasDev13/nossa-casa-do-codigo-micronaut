package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable
import org.slf4j.LoggerFactory

@Controller("api/autores/{id}")
class DeletaAutorController(val autorRepository: AutorRepository) {
    // {id} -> os {} indica que é uma variável que está vindo pela uri/pelo caminho do path
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Delete
    fun deleta(@PathVariable id: Long): HttpResponse<Any> {
        val possivelAutor = autorRepository.findById(id)
        if (possivelAutor.isEmpty){
            return HttpResponse.notFound("Autor não encontrado.")
        }
        //deletando pelo id
        //autorRepository.deleteById(id)
        //logger.info("Autor com $id deletado. ")

        //deletando pela entidade
        val autor = possivelAutor.get()
        autorRepository.delete(autor)
        logger.info("Autor com id ${autor.id} deletado. ")
        return HttpResponse.ok()
    }
}