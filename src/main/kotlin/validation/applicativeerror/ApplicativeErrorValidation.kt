package validation.applicativeerror

import kategory.*
import validation.Data
import validation.validMail
import validation.validNumber

object ApplicativeErrorValidation {

    inline fun <reified F> validateData(input: Data, AE: ApplicativeError<F, Nel<Error>> = applicativeError()): HK<F, Data> {
        val validatedMail = input.mail.validatedMail(AE)
        val validatedPhoneNumber = input.phone.validatedPhoneNumber(AE)

        return AE.map2(validatedMail, validatedPhoneNumber) {
            Data(it.a, it.b)
        }

    }

    inline fun <reified F> String.validatedMail(applicativeError: ApplicativeError<F, Nel<Error>>): HK<F, String> =
            when {
                validMail(this) -> applicativeError.pure(this)
                else -> applicativeError.raiseError(Error.InvalidMail.nel())
            }

    inline fun <reified F> String.validatedPhoneNumber(applicativeError: ApplicativeError<F, Nel<Error>>): HK<F, String> =
            when {
                validNumber(this) -> applicativeError.pure(this)
                else -> applicativeError.raiseError(Error.InvalidPhoneNumber.nel())
            }

}