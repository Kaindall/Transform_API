package br.com.personal.transform.domain.utils

import br.com.personal.transform.domain.model.exception.cnab.TransformException
import java.time.DateTimeException
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class CnabDateParser (
    private val year: String,
    private val month: String,
    private val day: String,
    private val hour: String,
    private val minute: String,
    private val second: String
) {
    fun parse(): String {
        val year: Int
        val month: Int
        val day: Int
        val hour: Int
        val minute: Int
        val second: Int

        try {year = this.year.toInt()} catch(e: NumberFormatException){
            throw TransformException.invalidDateField("ano", this.year)
        }
        try {month = this.month.toInt()} catch(e: NumberFormatException){
            throw TransformException.invalidDateField("mês", this.month)
        }
        try {day = this.day.toInt()} catch(e: NumberFormatException){
            throw TransformException.invalidDateField("dia", this.day)
        }
        try {hour = this.hour.toInt()} catch(e: NumberFormatException){
            throw TransformException.invalidDateField("hora", this.hour)
        }
        try {minute = this.minute.toInt()} catch(e: NumberFormatException){
            throw TransformException.invalidDateField("minuto", this.minute)
        }
        try {second = this.second.toInt()} catch(e: NumberFormatException){
            throw TransformException.invalidDateField("segundo", this.second)
        }

        val zonedDate = try {
            ZonedDateTime.of(
                LocalDateTime.of(year, month, day, hour, minute, second),
                ZoneId.of("America/Sao_Paulo")
            ).format(DateTimeFormatter.ofPattern("YYYY/MM/dd HH:mm:ss"))
        } catch (e: DateTimeException) {
            throw TransformException.invalidDate()
        }
        return zonedDate
    }

}