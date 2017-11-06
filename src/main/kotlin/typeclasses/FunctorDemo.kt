package typeclasses

import kategory.Functor
import kategory.HK
import kategory.functor

object FunctorDemo {

    inline fun <reified F> multiplyBy2(
            fa: HK<F, Int>,
            FT: Functor<F> = functor()): HK<F, Int> {
        return FT.map(fa, { it * 2 })
    }

}