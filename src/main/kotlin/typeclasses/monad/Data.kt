package typeclasses.monad

data class User(
        val userId: Int,
        val addressId: Int
)

data class Address(
        val addressId: Int,
        val addressLine: String
)


sealed class Error

object InvalidInput : Error()
object UserNotFound : Error()
object AddressNotFound : Error()

val users = listOf(
        User(1, 4),
        User(2, 5),
        User(3, 6)
)

val addresses = listOf(
        Address(4, "Via Calcinaro, 2861, 47521 Cesena FC"),
        Address(5, "Via Nerio Nannetti 1 - 40069 Zola Predosa (BO)")
)