import kategory.Try

fun <T> T.success() = Try.Success(this)
