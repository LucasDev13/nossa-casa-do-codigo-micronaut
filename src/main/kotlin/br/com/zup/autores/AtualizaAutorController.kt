package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put
import jakarta.inject.Inject

@Controller("/api/atualiza/autores")
class AtualizaAutorController(@Inject val autorRepository: AutorRepository) {
    @Put("/{id}")
    fun atualiza(@PathVariable id: Long, descricao: String): HttpResponse<Any>{
        //buscar o autor no banco
        val possivelAutor = autorRepository.findById(id)
        if(possivelAutor.isEmpty){
            return HttpResponse.notFound()
        }

        //atualizar o campo
        val autor = possivelAutor.get()
        autor.descricao = descricao
        autorRepository.update(autor)

        //retornar ok
        return HttpResponse.ok(DetalhesAutorResponse(autor))
    }
}