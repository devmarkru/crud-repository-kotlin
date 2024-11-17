package ru.devmark.crud.service

import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.devmark.crud.entity.Band
import ru.devmark.crud.exception.BandNotFoundException
import ru.devmark.crud.repository.BandRepository
import ru.devmark.crud.request.SaveBandRequest

@Service
class BandService(private val bandRepository: BandRepository) {

    fun getAll(): List<Band> {
        log.info("Get all bands")
        return bandRepository.findByOrderByName()
    }

    fun getById(id: Int): Band {
        log.info("Get band with id=$id")
        return bandRepository.findByIdOrNull(id)
            ?: throw BandNotFoundException(id)
    }

    fun create(request: SaveBandRequest) {
        log.info("Create new band with name=${request.name}")
        bandRepository.save(
            Band(
                name = request.name!!,
                playersCount = request.playersCount,
                created = request.created!!
            )
        )
    }

    fun update(id: Int, request: SaveBandRequest) {
        log.info("Update band with id=$id")
        val band = bandRepository.findByIdOrNull(id)
            ?: throw BandNotFoundException(id)
        band.name = request.name!!
        band.playersCount = request.playersCount
        band.created = request.created!!
        bandRepository.save(band)
    }

    fun delete(id: Int) {
        log.info("Delete band with id=$id")
        val band = bandRepository.findByIdOrNull(id) ?: throw BandNotFoundException(id)
        bandRepository.delete(band)
    }

    companion object {
        private val log = LoggerFactory.getLogger(BandService::class.java)
    }
}