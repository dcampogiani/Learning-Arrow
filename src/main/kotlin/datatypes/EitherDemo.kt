package datatypes

object EitherDemo {

    sealed class Either<E, A> {

        data class Left<E, A>(val error: E, val dummt: Unit) : Either<E, A>()
        data class Right<E, A>(val dummy: Unit, val value: A) : Either<E, A>()

        fun <B> map(f: (A) -> B): Either<E, B> = when (this) {
            is Left<E, A> -> Left(this.error, this.dummt)
            is Right<E, A> -> Right(this.dummy, f(this.value))
        }


        fun <B> flatMap(f: (A) -> Either<E, B>): Either<E, B> = when (this) {
            is Left<E, A> -> Left(this.error, this.dummt)
            is Right<E, A> -> f(this.value)
        }

        fun <B> fold(fa: (E) -> B, fb: (A) -> B): B = when (this) {
            is Right<E, A> -> fb(value)
            is Left<E, A> -> fa(error)
        }


        fun orElse(e: Either<E, A>): Either<E, A> = when (this) {
            is Left<E, A> -> e
            is Right<E, A> -> Right(this.dummy, this.value)
        }

        fun <B, C> map2(either2: Either<E, B>, f: (A, B) -> C): Either<E, C> =
                this.flatMap({ a -> either2.map({ b -> f(a, b) }) })
    }
}