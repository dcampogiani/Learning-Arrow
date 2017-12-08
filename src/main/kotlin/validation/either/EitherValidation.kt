package validation.either

import kategory.*
import validation.Data
import validation.validMail
import validation.validNumber

object EitherValidation {

    fun validateData(input: Data): Either<String, Data> {

        val mail = input.mail
        val phone = input.phone

        return Either.monadError<String>().map2(mail.eitherMail(), phone.eitherPhoneNumber()) {
            Data(it.a, it.b)
        }.ev()

    }


    private fun String.eitherMail(): Either<String, String> =
            when {
                validMail(this) -> this.right()
                else -> "Invalid email".left()
            }

    private fun String.eitherPhoneNumber(): Either<String, String> =
            when {
                validNumber(this) -> this.right()
                else -> "Invalid phone number".left()
            }
}