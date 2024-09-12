package br.com.personal.transform.controller

import br.com.personal.transform.domain.model.exception.cnab.TransformException
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(TransformException::class)
    fun handleException(exception: TransformException): ResponseEntity<TransformException> {
        return ResponseEntity(exception, HttpStatus.BAD_REQUEST)
    }
}