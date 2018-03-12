package typeclasses.monad

import arrow.HK
import arrow.syntax.applicative.pure
import arrow.typeclasses.MonadError
import arrow.typeclasses.binding
import arrow.typeclasses.monadError

inline fun <reified F> parseInt(input: String, ME: MonadError<F, Error> = monadError()): HK<F, Int> {

    return try {
        input.toInt().pure(ME)
    } catch (e: Exception) {
        ME.raiseError(InvalidInput)
    }
}

inline fun <reified F> findUserById(input: Int, ME: MonadError<F, Error> = monadError()): HK<F, User> {
    val user = users.find {
        it.userId == input
    }
    return user?.let { ME.pure(it) } ?: ME.raiseError(UserNotFound)
}

inline fun <reified F> findAddressById(input: Int, ME: MonadError<F, Error> = monadError()): HK<F, Address> {
    val address = addresses.find {
        it.addressId == input
    }
    return address?.let { ME.pure(it) } ?: ME.raiseError(AddressNotFound)
}

inline fun <reified F> process(inputString: String, ME: MonadError<F, Error> = monadError()): HK<F, Address> =
        ME.binding {
            val input = parseInt<F>(inputString).bind()
            val user = findUserById<F>(input).bind()
            findAddressById<F>(user.addressId).bind()
        }