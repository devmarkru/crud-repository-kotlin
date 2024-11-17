package ru.devmark.crud.repository

import org.springframework.data.repository.CrudRepository
import ru.devmark.crud.entity.Band

interface BandRepository : CrudRepository<Band, Int> {

    fun findByOrderByName(): List<Band>
}
