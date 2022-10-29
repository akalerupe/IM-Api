package com.example.InstitutionManagement.config

import com.example.InstitutionManagement.model.ErrorMessage
import org.hibernate.exception.ConstraintViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException
import javax.persistence.EntityNotFoundException
import javax.persistence.NoResultException

@ControllerAdvice
class ControllerExceptionsHandler {

    @ExceptionHandler(
            ConstraintViolationException::class,
            HttpClientErrorException.BadRequest::class,
            MethodArgumentNotValidException::class,
            MissingServletRequestParameterException::class,
            IllegalArgumentException::class
    )
    fun constraintViolationException(e: Exception): ResponseEntity<ErrorMessage> {
        return generateErrorResponse(HttpStatus.BAD_REQUEST, "Bad request", e)
    }

    @ExceptionHandler(
            EntityNotFoundException::class,
            NoSuchElementException::class,
            NoResultException::class,
            EmptyResultDataAccessException::class,
            IndexOutOfBoundsException::class,
            KotlinNullPointerException::class
    )
    fun notFoundException(e: Exception): ResponseEntity<ErrorMessage> {
        return generateErrorResponse(HttpStatus.NOT_FOUND, "Resource not found", e)
    }

    @ExceptionHandler(
            Exception::class
    )
    fun internalServerErrorException(e: Exception): ResponseEntity<ErrorMessage> {
        return generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "internal  server error", e)
    }

    private fun generateErrorResponse(
            status: HttpStatus,
            message: String,
            e: Exception
    ): ResponseEntity<ErrorMessage> {
        return ResponseEntity(ErrorMessage(), status)
    }

}