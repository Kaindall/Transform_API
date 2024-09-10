package br.com.personal.transform.service.impl

<<<<<<<< HEAD:src/main/kotlin/br/com/personal/transform/domain/service/impl/TransformServiceImpl.kt
========
import br.com.personal.transform.domain.service.builder.TransactionBuilder
>>>>>>>> 4b1c9652ac10fc0876e8964604ef4ea4abbc2560:src/main/kotlin/br/com/personal/transform/domain/service/impl/JsonConverterImpl.kt
import br.com.personal.transform.model.entity.Transaction
import br.com.personal.transform.model.mapper.TransactionMapper
import br.com.personal.transform.service.TransformService
import org.springframework.stereotype.Service

@Service
class TransformServiceImpl: TransformService {
    override fun fromCnab(cnab: String): Transaction {
        val cnabFormated = cnab.trim('"').padEnd(82, ' ')
        return  TransactionMapper.toTransaction(cnabFormated)
    }

}