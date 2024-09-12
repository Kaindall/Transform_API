package br.com.personal.transform.domain.service

import br.com.personal.transform.domain.model.entity.Transaction
import br.com.personal.transform.domain.utils.TransactionParser
import org.springframework.stereotype.Service

@Service
class TransformService {
    fun toTransaction(cnab: String): Transaction {
        val cnabFormated = cnab.trim('"').padEnd(82, ' ')
        return  TransactionParser.fromCnab(cnabFormated)
    }

}