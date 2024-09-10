package br.com.personal.transform.domain.model.entity

import br.com.personal.transform.domain.model.enums.TransactionTypeEnum

data class Transaction(
    val type: TransactionTypeEnum,
    val amount: Double,
    val date: String,
    val targetCpf: String,
    val card: String,
    val originOwner: String,
    val originStore: String
) {

}