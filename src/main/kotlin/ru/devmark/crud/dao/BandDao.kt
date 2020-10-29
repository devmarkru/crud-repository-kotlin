package ru.devmark.crud.dao

import org.springframework.data.repository.CrudRepository
import ru.devmark.crud.model.Band

interface BandDao : CrudRepository<Band, Int> {

    fun findByOrderByName(): List<Band>
}