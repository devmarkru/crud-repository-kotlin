package ru.devmark.crud.service

import ru.devmark.crud.model.Band
import ru.devmark.crud.request.SaveBandRequest

interface BandService {

    fun findAll(): List<Band>

    fun findById(id: Int): Band

    fun create(request: SaveBandRequest)

    fun update(id: Int, request: SaveBandRequest)

    fun delete(id: Int)
}