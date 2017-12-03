package validation.validated

import kategory.*
import validation.Data
import validation.validMail
import validation.validNumber

object ValidatedNelStringValidation {

    fun validateData(input: Data): Validated<Nel<String>, Data> {

        val mail = input.mail
        val phone = input.phone

        return Validated.applicative<Nel<String>>().map2(mail.validatedMail(), phone.validatedPhoneNumber()) {
            Data(it.a, it.b)
        }.ev()

    }


    private fun String.validatedMail(): Validated<Nel<String>, String> =
            when {
                validMail(this) -> this.valid()
                else -> "Invalid email".nel().invalid()
            }

    private fun String.validatedPhoneNumber(): Validated<Nel<String>, String> =
            when {
                validNumber(this) -> this.valid()
                else -> "Invalid phone number".nel().invalid()
            }
}