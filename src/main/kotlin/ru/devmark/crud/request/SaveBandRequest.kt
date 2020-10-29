package ru.devmark.crud.request

import java.time.LocalDate
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import javax.validation.constraints.Positive
import javax.validation.constraints.Size

data class SaveBandRequest (

        @get:NotNull
        @get:Size(min = 1, max = 50)
        val name: String?,

        @get:Positive
        val playersCount: Int,

        @get:NotNull
        @get:Past
        val created: LocalDate?
)