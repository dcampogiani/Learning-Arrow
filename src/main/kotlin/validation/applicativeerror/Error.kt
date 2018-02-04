package validation.applicativeerror

sealed class Error {

    object InvalidMail : Error()
    object InvalidPhoneNumber : Error()
}