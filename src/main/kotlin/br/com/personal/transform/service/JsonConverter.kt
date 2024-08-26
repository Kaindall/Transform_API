package br.com.personal.transform.service

import br.com.personal.transform.model.entity.TransactionEntity

interface JsonConverter {
    fun fromCnab(cnab: String): TransactionEntity
}