package br.com.personal.transform.controller

import br.com.personal.transform.model.entity.TransactionEntity
import br.com.personal.transform.service.JsonConverterService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transform")
class TransformController {

    @PostMapping("/cnab")
    fun transformCnab(@RequestBody cnab: String): ResponseEntity<TransactionEntity> {
        return ResponseEntity(JsonConverterService.fromCnab(cnab), HttpStatus.OK)
    }

    @GetMapping("/hello")
    fun handshake(): ResponseEntity<String> = ResponseEntity("Hello world!", HttpStatus.OK)
}