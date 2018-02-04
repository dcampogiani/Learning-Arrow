package typeclasses.monad

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import arrow.syntax.either.right

internal fun parseIntEither(input: String): Either<Error, Int> {
    return try {
        input.toInt().right()
    } catch (e: Exception) {
        Left(InvalidInput)
    }
}

internal fun findUserByIdEither(input: Int): Either<Error, User> {
    val user = users.find {
        it.userId == input
    }
    return user?.let { Right(it) } ?: Left(UserNotFound)
}

internal fun findAddressByIdEither(input: Int): Either<Error, Address> {
    val address = addresses.find {
        it.addressId == input
    }
    return address?.let { Right(it) } ?: Left(AddressNotFound)
}