package ru.devmark.crud.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class BandNotFoundException(id: Int): RuntimeException("Band with id=$id not found")