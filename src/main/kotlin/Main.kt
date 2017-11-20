import kategory.Option
import kategory.Try
import kategory.ev
import kategory.some
import typeclasses.FunctorDemo

fun main(args: Array<String>) {


    val some10 = 10.some()
    val success10 = 10.success()

    val optionFun: Option<Int> = FunctorDemo.multiplyBy2(some10).ev()
    val tryFun: Try<Int> = FunctorDemo.multiplyBy2(success10).ev()

    println("Option : $optionFun")
    println("Try : $tryFun")

}

private fun <T> T.success() = Try.Success(this)
