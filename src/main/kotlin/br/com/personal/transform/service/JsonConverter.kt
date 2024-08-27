package br.com.personal.transform.service

import br.com.personal.transform.model.entity.Transaction

interface JsonConverter {
    fun fromCnab(cnab: String): Transaction
}