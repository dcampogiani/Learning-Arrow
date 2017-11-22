package typeclasses

import kategory.*
import success

object FunctorDemo {

    operator fun invoke() {

        val some10 = 10.some()
        val success10 = 10.success()

        val optionFun: Option<Int> = FunctorDemo.multiplyBy2(some10).ev()
        val tryFun: Try<Int> = FunctorDemo.multiplyBy2(success10).ev()

        println("Option : $optionFun")
        println("Try : $tryFun")

    }

    inline fun <reified F> multiplyBy2(
            fa: HK<F, Int>,
            FT: Functor<F> = functor()): HK<F, Int> {
        return FT.map(fa, { it * 2 })
    }

}