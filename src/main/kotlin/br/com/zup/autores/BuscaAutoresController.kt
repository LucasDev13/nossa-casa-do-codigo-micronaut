package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("api/busca/autores")
class BuscaAutoresController(val autorRepository: AutorRepository) {

    @Get
    fun listaAutores(): HttpResponse<List<DetalhesAutorResponse>>{
        //pegar do banco de dados
        val autores = autorRepository.findAll()

        //conversão para um dto
        val response = autores.map { autor -> DetalhesAutorResponse(autor) }
        //retornar essa lista.
        return HttpResponse.ok(response)
    }
}