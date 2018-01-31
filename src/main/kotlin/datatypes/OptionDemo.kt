package datatypes

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.getOrElse
import arrow.syntax.option.some

object OptionDemo {

    operator fun invoke() {
        demoCreate()
        demoGetOrElse()
        demoIs()
        demoWhen()
        demoMap()
        demoFold()
        demoExtensions()
    }

    private fun demoCreate() {
        println("demoCreate")

        val some = Some("Wrapped")
        println(some)

        val none = None
        println(none)
    }

    private fun maybeItWillReturnSomething(flag: Boolean): Option<String> =
        if (flag) Some("Found value") else None

    private fun demoGetOrElse() {
        println("demoGetOrElse")

        val firstOption = maybeItWillReturnSomething(true)
        val secondOption = maybeItWillReturnSomething(false)

        val firstValue = firstOption.getOrElse { "No Value" }
        val secondValue = secondOption.getOrElse { "No value" }

        println(firstValue)
        println(secondValue)
    }

    private fun demoIs() {
        println("demoIs")

        val option = maybeItWillReturnSomething(false)

        val isNone = option is None

        println("Option is none: $isNone")
    }

    private fun demoWhen() {
        println("demoWhen")

        val firstOption: Option<Double> = Some(20.0)

        val firstValue = when (firstOption) {
            is Some -> firstOption.t
            is None -> 0.0
        }

        println(firstValue)

        val secondOption: Option<Double> = None

        val secondValue = when (secondOption) {
            is Some -> secondOption.t
            is None -> 0.0
        }

        println(secondValue)
    }

    private fun demoMap() {
        println("demoMap")

        val number: Option<Int> = Some(42)
        val noNumber: Option<Int> = None

        val firstMapped = number.map { it * 2 }
        val secondMapped = noNumber.map { it * 3 }

        println(firstMapped)
        println(secondMapped)
    }

    private fun demoFold() {
        println("demoFold")

        val number: Option<Int> = Some(42)
        val noNumber: Option<Int> = None

        val firstValue = number.fold({ 2 }) { it * 2 }
        val secondValue = noNumber.fold({ 2 }) { it * 2 }

        println(firstValue)
        println(secondValue)
    }

    private fun demoExtensions() {
        println("demoExtensions")

        val some = 2.some()

        println(some)
    }
}