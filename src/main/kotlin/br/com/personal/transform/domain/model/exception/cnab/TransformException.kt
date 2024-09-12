package br.com.personal.transform.domain.model.exception.cnab

import java.time.LocalDateTime

class TransformException (
    val code: Int,
    override val message: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
): RuntimeException() {
    companion object {
        fun typeNotExists(type: Int): TransformException {
            return TransformException(1, "O tipo $type não foi encontrado")
        }

        fun invalidType(type: String): TransformException {
            return TransformException(2, "O tipo $type é inválido")
        }

        fun invalidAmount(value: Double): TransformException {
            return TransformException(10, "O valor $value é inválido")
        }

        fun invalidDateField(field: String, value: String): TransformException {
            return TransformException(21, "O valor $value não pode ser inserido no $field")
        }

        fun invalidDate(): TransformException {
            return TransformException(22, "Falha ao converter a data da operação")
        }

        fun unknownError(msg: String): TransformException {
            return TransformException(99, msg)
        }

    }
}