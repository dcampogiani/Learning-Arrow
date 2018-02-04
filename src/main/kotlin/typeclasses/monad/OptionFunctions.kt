package typeclasses.monad

import arrow.core.None
import arrow.core.Option
import arrow.syntax.option.some
import arrow.syntax.option.toOption

internal fun parseIntOption(input: String): Option<Int> {
    return try {
        input.toInt().some()
    } catch (e: Exception) {
        None
    }
}

internal fun findUserByIdOption(input: Int): Option<User> {
    return users.find {
        it.userId == input
    }.toOption()
}

internal fun findAddressByIdOption(input: Int): Option<Address> {
    return addresses.find {
        it.addressId == input
    }.toOption()
}