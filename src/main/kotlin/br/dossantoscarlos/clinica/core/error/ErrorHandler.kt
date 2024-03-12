package br.dossantoscarlos.clinica.core.error

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(EmptyResultDataAccessException::class)
    fun notFoundHandler(ex: EmptyResultDataAccessException): ResponseEntity<Any> {

        val responseError = ResponseError(
            HttpStatus.NOT_FOUND.value(),
            ex.message ?: "O recurso solicitado não foi encontrado"
        )
        return ResponseEntity(responseError, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(Exception::class)
    fun internalErrorHandler(ex: Exception): ResponseEntity<Any> {
        val responseError = ResponseError(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.message ?: "Ocorreu um erro"
        )
        return ResponseEntity(responseError, HttpStatus.INTERNAL_SERVER_ERROR)
    }


}

data class ResponseError(val status: Int, val message: String)
