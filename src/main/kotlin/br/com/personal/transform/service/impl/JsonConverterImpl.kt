package br.com.personal.transform.service.impl

import br.com.personal.transform.model.builder.TransactionBuilder
import br.com.personal.transform.model.entity.TransactionEntity
import br.com.personal.transform.service.JsonConverter
import org.springframework.stereotype.Service

@Service
class JsonConverterImpl: JsonConverter {
    override fun fromCnab(cnab: String): TransactionEntity {
        val cnabFormated = cnab.trim('"').padEnd(82, ' ')
        return  TransactionBuilder.build(cnabFormated)
    }

}