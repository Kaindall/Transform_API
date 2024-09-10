package br.com.personal.transform.controller

import br.com.personal.transform.model.entity.Transaction
<<<<<<< HEAD
import br.com.personal.transform.service.TransformService
=======
import br.com.personal.transform.domain.service.JsonConverter
>>>>>>> 4b1c9652ac10fc0876e8964604ef4ea4abbc2560
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
}