import arrow.data.Try

fun <T> T.success() = Try.Success(this)
