package br.com.personal.transform.domain.utils

import br.com.personal.transform.domain.model.entity.Transaction
import br.com.personal.transform.domain.model.enums.TransactionTypeEnum
import br.com.personal.transform.domain.model.exception.cnab.TransformException


//TODO: Exceção para cada tipo de erro possível
class TransactionParser {
    companion object {
        fun fromCnab(cnab: String): Transaction {
            val typeId = try {
                cnab.substring(0, 1).toInt()
            } catch (e: RuntimeException) {
                if (e is NumberFormatException || e is IllegalArgumentException) {
                    throw TransformException.invalidType(cnab.substring(0, 1))
                } else {
                    throw TransformException.unknownError(e.localizedMessage)
                }
            }
            val type = TransactionTypeEnum.fromId(typeId)?:throw TransformException.typeNotExists(typeId)

            val zonedDate: String = CnabDateParser(
                cnab.substring(1, 5),
                cnab.substring(7, 9),
                cnab.substring(42, 44),
                cnab.substring(42, 44),
                cnab.substring(44, 46),
                cnab.substring(46, 48)
            ).parse()

            val amount: Double = (cnab.substring(9, 19).toDouble())/100
            val targetCpf = cnab.substring(19, 30)
            val card = cnab.substring(30, 42)
            val originOwner = cnab.substring(48, 62).trim(' ')
            val originStore = cnab.substring(62, 81).trim(' ')

            return Transaction(type, amount, zonedDate, targetCpf, card, originOwner, originStore)
        }
    }
}