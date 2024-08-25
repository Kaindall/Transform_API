package br.com.personal.transform.model.builder

import br.com.personal.transform.exception.transaction.GenericException
import br.com.personal.transform.exception.transaction.cnab.InvalidAmountException
import br.com.personal.transform.exception.transaction.cnab.TypeNotFoundException
import br.com.personal.transform.model.entity.TransactionEntity
import br.com.personal.transform.model.enums.TransactionTypeEnum
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class TransactionBuilder {
    companion object {
        fun build(cnab: String): TransactionEntity {
            val zonedDate = ZonedDateTime.of(LocalDateTime.of(
                cnab.substring(1, 5).toInt(),
                cnab.substring(5, 7).toInt(),
                cnab.substring(7, 9).toInt(),
                cnab.substring(42, 44).toInt(),
                cnab.substring(44, 46).toInt(),
                cnab.substring(46, 48).toInt()), ZoneId.of("America/Sao_Paulo"))

            return try {
                TransactionEntity(
                type = TransactionTypeEnum.fromId(cnab.substring(0, 1).toInt())
                    ?: throw TypeNotFoundException(),
                amount = (cnab.substring(9, 19).toDouble()) / 100,
                date = zonedDate.format(DateTimeFormatter.ofPattern("YYYY/MM/dd HH:mm:ss")),
                targetCpf = cnab.substring(19, 30),
                card = cnab.substring(30, 42),
                originOwner = cnab.substring(48, 62).trim(' '),
                originStore = cnab.substring(62, 81).trim(' ')
            )} catch (exception: TypeNotFoundException) {
                throw exception
            } catch (exception: NumberFormatException) {
                throw InvalidAmountException()
            } catch (exception: Exception) {
                throw GenericException("O CNAB informado é inválido!")
            }
        }
    }
}