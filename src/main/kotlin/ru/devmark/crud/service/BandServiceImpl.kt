package ru.devmark.crud.service

import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.devmark.crud.dao.BandDao
import ru.devmark.crud.exception.BandNotFoundException
import ru.devmark.crud.model.Band
import ru.devmark.crud.request.SaveBandRequest

@Service
class BandServiceImpl(private val bandDao: BandDao) : BandService {

    override fun findAll(): List<Band> {
        log.info("Find all bands")
        return bandDao.findByOrderByName()
    }

    override fun findById(id: Int): Band {
        log.info("Find band with id=$id")
        return bandDao.findByIdOrNull(id) ?: throw BandNotFoundException(id)
    }

    override fun create(request: SaveBandRequest) {
        log.info("Create new band with name=${request.name}")
        bandDao.save(
                Band(
                        name = request.name!!,
                        playersCount = request.playersCount,
                        created = request.created!!
                )
        )
    }

    override fun update(id: Int, request: SaveBandRequest) {
        log.info("Update band with id=$id")
        val band = bandDao.findByIdOrNull(id) ?: throw BandNotFoundException(id)
        bandDao.save(
                band.copy(
                        name = request.name!!,
                        playersCount = request.playersCount,
                        created = request.created!!
                )
        )
    }

    override fun delete(id: Int) {
        log.info("Delete band with id=$id")
        val band = bandDao.findByIdOrNull(id) ?: throw BandNotFoundException(id)
        bandDao.delete(band)
    }

    companion object {
        private val log = LoggerFactory.getLogger(BandServiceImpl::class.java)
    }
}