package ru.devmark.crud.controller

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.devmark.crud.entity.Band
import ru.devmark.crud.request.SaveBandRequest
import ru.devmark.crud.response.StatusResponse
import ru.devmark.crud.service.BandService

@RestController
@RequestMapping("/bands")
class BandController(
    private val bandService: BandService,
) {

    @GetMapping
    fun findAll() = bandService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Int): Band {
        return bandService.findById(id)
    }

    @PostMapping
    fun create(@Valid @RequestBody request: SaveBandRequest): StatusResponse {
        bandService.create(request)
        return StatusResponse("Created")
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable("id") id: Int,
        @Valid @RequestBody request: SaveBandRequest
    ): StatusResponse {
        bandService.update(id, request)
        return StatusResponse("Updated")
    }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable("id") id: Int
    ): StatusResponse {
        bandService.delete(id)
        return StatusResponse("Deleted")
    }
}
