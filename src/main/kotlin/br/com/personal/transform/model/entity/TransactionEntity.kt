package br.com.personal.transform.model.entity

import br.com.personal.transform.model.enums.TransactionTypeEnum


data class TransactionEntity(
    val type: TransactionTypeEnum,
    val amount: Double,
    val date: String,
    val targetCpf: String,
    val card: String,
    val originOwner: String,
    val originStore: String
) {

}