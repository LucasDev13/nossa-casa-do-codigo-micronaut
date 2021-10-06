package br.com.zup.autores

import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

@Controller("api/busca/autores")
class BuscaAutoresController(val autorRepository: AutorRepository) {

    @Get("/lista")
    fun listaAutores(@QueryValue(defaultValue = "") email: String): HttpResponse<Any> {
        if (email.isBlank()) {
            //pegar do banco de dados
            val autores = autorRepository.findAll()

            //conversão para um dto
            val response = autores.map { autor -> DetalhesAutorResponse(autor) }
            //retornar essa lista.
            return HttpResponse.ok(response)
        }
//        val possivelAutor = autorRepository.findByEmail(email) //usando query method
        val possivelAutor = autorRepository.buscaEmail(email)// -> usando @Query

        if (possivelAutor.isEmpty) {
            return HttpResponse.notFound()
        }
        val autor = possivelAutor.get()
        return HttpResponse.ok(DetalhesAutorResponse(autor))
    }

    @Get("/paginacao")
    fun listaNomesPaginados(@QueryValue(defaultValue = "") nome: String): HttpResponse<Any> {
        val paginacaoNome = autorRepository.findByNome(nome, Pageable.from(0,5))
        return HttpResponse.ok(paginacaoNome)
    }

}