package br.com.personal.transform.service

import br.com.personal.transform.domain.model.entity.Transaction

interface TransformService {
    fun fromCnab(cnab: String): Transaction
}