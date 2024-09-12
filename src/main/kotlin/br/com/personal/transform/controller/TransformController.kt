package br.com.personal.transform.controller

import br.com.personal.transform.domain.model.entity.Transaction
import br.com.personal.transform.domain.service.TransformService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transform")
class TransformController(
    private val transformService: TransformService,
) {

    @PostMapping("/cnab")
    fun transformCnab(@RequestBody cnab: String): ResponseEntity<Transaction> {
        return ResponseEntity(transformService.toTransaction(cnab), HttpStatus.OK)
    }
}