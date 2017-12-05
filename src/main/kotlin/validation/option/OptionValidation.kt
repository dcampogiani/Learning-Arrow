package validation.option

import kategory.Option
import kategory.applicative
import kategory.ev
import kategory.some
import validation.Data

object OptionValidation {

    fun validateData(input: Data): Option<Data> {

        val mail = input.mail
        val phone = input.phone
        return Option.applicative().map2(mail.optionMail(), phone.optionPhoneNumber()) {
            Data(it.a, it.b)
        }.ev()

    }


    private fun String.optionMail(): Option<String> =
            when {
                validation.validMail(this) -> this.some()
                else -> Option.None
            }

    private fun String.optionPhoneNumber(): Option<String> =
            when {
                validation.validNumber(this) -> this.some()
                else -> Option.None
            }
}