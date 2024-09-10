package br.com.personal.transform.service.impl

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