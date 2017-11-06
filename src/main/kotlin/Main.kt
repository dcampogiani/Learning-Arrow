import kategory.*
import typeclasses.FunctorDemo

fun main(args: Array<String>) {


    val some10 = 10.some()
    val success10 = 10.success()

    val optionFun = FunctorDemo.multiplyBy2<OptionHK>(some10)
    val tryFun = FunctorDemo.multiplyBy2<TryHK>(success10)

    println("Option : $optionFun")
    println("Try : $tryFun")

}

private fun <T> T.success() = Try.Success(this)
