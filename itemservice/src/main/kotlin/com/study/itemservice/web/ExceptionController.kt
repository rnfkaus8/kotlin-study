package com.study.itemservice.web

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionController {
    private val log = LoggerFactory.getLogger(javaClass)
    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun exceptionHandler(e: IllegalStateException) {
        log.error("exceptionHandler error", e)
    }
}