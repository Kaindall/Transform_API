package br.com.personal.transform.controller

import br.com.personal.transform.model.entity.Transaction
import br.com.personal.transform.domain.service.JsonConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transform")
class TransformController(
    private val jsonConverter: JsonConverter,
) {

    @PostMapping("/cnab")
    fun transformCnab(@RequestBody cnab: String): ResponseEntity<Transaction> {
        return ResponseEntity(jsonConverter.fromCnab(cnab), HttpStatus.OK)
    }
}