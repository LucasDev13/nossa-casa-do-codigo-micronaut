package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.validation.Valid
import javax.validation.Validator

@Validated
@Controller("/api/autores")
class CadastraAutorController(val autorRepository: AutorRepository) {

    val logger: Logger = LoggerFactory.getLogger("CadastraAutorController.class")
    @Post
    fun cadastra(@Body @Valid request: NovoAutorRequest): HttpResponse<Any>{
        val autor = request.toModel()
        autorRepository.save(autor)

        logger.info("Cadastrado realizado.")

        val uri = UriBuilder.of("/autores/{id}")
            .expand(mutableMapOf(Pair("id", autor.id)))
        return HttpResponse.created(uri)
    }

}