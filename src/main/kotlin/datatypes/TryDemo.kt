package datatypes

object TryDemo {

    fun parseInt(string: String) = Try.make {
        string.toInt()
    }

    fun multuplyBy2(value: Int) = value * 2

}

sealed class Try<out A> {

    companion object {
        fun <A> make(producer: () -> A): Try<A> {
            return try {
                Success(producer())
            } catch (t: Throwable) {
                Fail(t)
            }
        }
    }

    class Fail(val throwable: Throwable) : Try<Nothing>()
    class Success<A>(val value: A) : Try<A>()


    fun <B> map(f: (A) -> B): Try<B> = when (this) {
        is Try.Fail -> Fail(throwable)
        is Try.Success -> Success(f(value))
    }

    fun <B> flatMap(f: (A) -> Try<B>): Try<B> = when (this) {
        is Try.Fail -> Fail(throwable)
        is Try.Success -> f(value)
    }
}