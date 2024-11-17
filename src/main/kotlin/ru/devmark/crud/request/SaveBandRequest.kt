package ru.devmark.crud.request

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class SaveBandRequest(

    @get:NotNull
    @get:Size(min = 1, max = 50)
    val name: String?,

    @get:Positive
    val playersCount: Int,

    @get:NotNull
    @get:Past
    val created: LocalDate?
)
