package validation.validated

import arrow.data.ListKW
import arrow.data.Validated
import arrow.data.applicative
import arrow.data.ev
import arrow.data.k
import arrow.syntax.validated.invalid
import arrow.syntax.validated.valid
import validation.Data
import validation.validMail
import validation.validNumber

object ValidatedListStringValidation {

    fun validateData(input: Data): Validated<ListKW<String>, Data> {

        val mail = input.mail
        val phone = input.phone

        return Validated.applicative<ListKW<String>>().map2(mail.validatedMail(), phone.validatedPhoneNumber()) {
            Data(it.a, it.b)
        }.ev()
    }

    private fun String.validatedMail(): Validated<ListKW<String>, String> =
        when {
            validMail(this) -> this.valid()
            else -> listOf("Invalid email").k().invalid()
        }

    private fun String.validatedPhoneNumber(): Validated<ListKW<String>, String> =
        when {
            validNumber(this) -> this.valid()
            else -> listOf("Invalid phone number").k().invalid()
        }
}