package br.com.personal.transform.controller.exception

import br.com.personal.transform.model.exception.cnab.InvalidAmountException
import br.com.personal.transform.model.exception.cnab.TypeNotFoundException
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
class TransactionExceptionHandler {
    @ExceptionHandler(TypeNotFoundException::class)
    fun handleTypeNotFoundException(exception: TypeNotFoundException): ResponseEntity<String> {
        return ResponseEntity(exception.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(InvalidAmountException::class)
    fun handleTypeNotFoundException(exception: InvalidAmountException): ResponseEntity<String> {
        return ResponseEntity(exception.message, HttpStatus.BAD_REQUEST)
    }
}