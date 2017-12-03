package validation.validated

import kategory.*
import validation.Data
import validation.validMail
import validation.validNumber

object ValidatedStringValidation {

    fun validateData(input: Data): Validated<String, Data> {

        val mail = input.mail
        val phone = input.phone

        return Validated.applicative<String>().map2(mail.validatedMail(), phone.validatedPhoneNumber()) {
            Data(it.a, it.b)
        }.ev()

    }


    private fun String.validatedMail(): Validated<String, String> =
            when {
                validMail(this) -> this.valid()
                else -> "Invalid email".invalid()
            }

    private fun String.validatedPhoneNumber(): Validated<String, String> =
            when {
                validNumber(this) -> this.valid()
                else -> "Invalid phone number".invalid()
            }
}