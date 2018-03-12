package typeclasses.monad

import arrow.HK
import arrow.core.*
import arrow.typeclasses.binding


object MonadDemo {

    fun flatMapsOption() {

        val addressForUser1 = parseIntOption("1")
                .flatMap { input -> findUserByIdOption(input) }
                .flatMap { user -> findAddressByIdOption(user.addressId) }

        println(addressForUser1)

        val wrongInput = parseIntOption("notANumber")
                .flatMap { input -> findUserByIdOption(input) }
                .flatMap { user -> findAddressByIdOption(user.addressId) }

        println(wrongInput)

        val addressForUser4 = parseIntOption("4")
                .flatMap { input -> findUserByIdOption(input) }
                .flatMap { user -> findAddressByIdOption(user.addressId) }

        println(addressForUser4)

        val addressForUser3 = parseIntOption("3")
                .flatMap { input -> findUserByIdOption(input) }
                .flatMap { user -> findAddressByIdOption(user.addressId) }

        println(addressForUser3)

    }

    fun forComprehensionOptions() {

        val addressForUser1 = Option.monad().binding {
            val input = parseIntOption("1").bind()
            val user = findUserByIdOption(input).bind()
            findAddressByIdOption(user.addressId)
        }
        println(addressForUser1)
    }

    fun forComprehensionEither() {

        val addressForUser1 = Either.monad<Error>().binding {
            val input = parseIntEither("1").bind()
            val user = findUserByIdEither(input).bind()
            findAddressByIdEither(user.addressId)
        }.ev()

        val wrongInput = Either.monad<Error>().binding {
            val input = parseIntEither("NotANumber").bind()
            val user = findUserByIdEither(input).bind()
            findAddressByIdEither(user.addressId)
        }.ev()

        val addressForUser3 = Either.monad<Error>().binding {
            val input = parseIntEither("3").bind()
            val user = findUserByIdEither(input).bind()
            findAddressByIdEither(user.addressId)
        }.ev()

        val addressForUser4 = Either.monad<Error>().binding {
            val input = parseIntEither("4").bind()
            val user = findUserByIdEither(input).bind()
            findAddressByIdEither(user.addressId)
        }.ev()

        println(addressForUser1)
        println(wrongInput)
        println(addressForUser3)
        println(addressForUser4)
    }

    fun polymorphic() {

        val user1 = process("1", Either.monadError()).ev()
        val invalidInput: HK<EitherKindPartial<Error>, Address> = process("NotANumber")
        val user3 = process("3", Either.monadError()).ev()
        val user4 = process("4", Either.monadError()).ev()


        println(user1)
        println(invalidInput)
        println(user3)
        println(user4)
    }
}