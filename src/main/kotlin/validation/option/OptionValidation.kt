package validation.option

import arrow.core.*
import arrow.syntax.option.some

import validation.Data

object OptionValidation {

    fun validateData(input: Data): Option<Data> {

        val mail = input.mail
        val phone = input.phone
        return Option.monadError().map2(mail.optionMail(), phone.optionPhoneNumber()) {
            Data(it.a, it.b)
        }.ev()
    }

    private fun String.optionMail(): Option<String> =
        when {
            validation.validMail(this) -> this.some()
            else -> None
        }

    private fun String.optionPhoneNumber(): Option<String> =
        when {
            validation.validNumber(this) -> this.some()
            else -> None
        }
}