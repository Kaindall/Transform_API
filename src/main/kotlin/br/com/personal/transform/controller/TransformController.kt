package br.com.personal.transform.controller

import br.com.personal.transform.model.entity.Transaction
import br.com.personal.transform.service.TransformService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transform")
class TransformController(
    private val transformService: TransformService,
) {

    @PostMapping("/cnab")
    fun transformCnab(@RequestBody cnab: String): ResponseEntity<Transaction> {
        return ResponseEntity(transformService.fromCnab(cnab), HttpStatus.OK)
    }

    @GetMapping("/hello")
    fun handshake(): ResponseEntity<String> = ResponseEntity("Hello world!", HttpStatus.OK)
}