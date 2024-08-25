package br.com.personal.transform.model.enums

enum class TransactionTypeEnum(
    val id: Int,
    val type: String,
    val kind: String,
    val signal: Char
) {
    DEBITO(1, "Débito", "Input", '+'),
    BOLETO(2, "Boleto", "Output", '-'),
    FINANCIAMENTO(3, "Financiamento", "Output", '-'),
    CREDITO(4, "Crédito", "Input", '+'),
    RECEBIMENTO_EMPRESTIMO(5, "Recebimento de Empréstimo", "Input", '+'),
    VENDAS(6, "Vendas", "Vendas", '+'),
    RECEBIMENTO_TED(7, "Recebimento de TED", "Input", '+'),
    RECEBIMENTO_DOC(8, "Recebimento de DOC", "Input", '+'),
    ALUGUEL(9, "Aluguel", "Output", '-');

    companion object {
        fun fromId(id: Int): TransactionTypeEnum? {
           return entries.find { it.id == id }
        }
    }
}