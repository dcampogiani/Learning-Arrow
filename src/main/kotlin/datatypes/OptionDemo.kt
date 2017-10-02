package datatypes

import kategory.Option
import kategory.getOrElse
import kategory.some

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

        val some = Option.Some("Wrapped")
        println(some)

        val none = Option.None
        println(none)
    }

    private fun maybeItWillReturnSomething(flag: Boolean): Option<String> =
            if (flag) Option.Some("Found value") else Option.None

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

        val isNone = option is Option.None

        println("Option is none: $isNone")

    }

    private fun demoWhen() {
        println("demoWhen")

        val firstOption: Option<Double> = Option.Some(20.0)

        val firstValue = when (firstOption) {
            is Option.Some -> firstOption.value
            is Option.None -> 0.0
        }

        println(firstValue)

        val secondOption: Option<Double> = Option.None

        val secondValue = when (secondOption) {
            is Option.Some -> secondOption.value
            is Option.None -> 0.0
        }

        println(secondValue)

    }

    private fun demoMap() {
        println("demoMap")

        val number: Option<Int> = Option.Some(42)
        val noNumber: Option<Int> = Option.None

        val firstMapped = number.map { it * 2 }
        val secondMapped = noNumber.map { it * 3 }

        println(firstMapped)
        println(secondMapped)
    }

    private fun demoFold() {
        println("demoFold")

        val number: Option<Int> = Option.Some(42)
        val noNumber: Option<Int> = Option.None

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