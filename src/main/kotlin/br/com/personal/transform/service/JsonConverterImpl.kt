package br.com.personal.transform.service

import br.com.personal.transform.model.builder.TransactionBuilder
import br.com.personal.transform.model.entity.TransactionEntity
import org.springframework.stereotype.Component

@Component
class JsonConverterImpl: JsonConverter {
    override fun fromCnab(cnab: String): TransactionEntity {
        val cnabFormated = cnab.trim('"').padEnd(82, ' ')
        return  TransactionBuilder.build(cnabFormated)
    }

}