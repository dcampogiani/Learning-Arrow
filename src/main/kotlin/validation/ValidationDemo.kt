package validation

import validation.either.EitherValidation
import validation.option.OptionValidation
import validation.validated.ValidatedStringValidation

object ValidationDemo {

    val first = Data("parenzio@gmail.com", "1234567872")
    val second = Data("parenzio.com", "1234567872")
    val third = Data("parenzio@gmail.com", "23")
    val fourth = Data("parenzio.com", "23")


    fun option() {

        println()
        println("Option")
        println()

        val optionFirst = OptionValidation.validateData(first)
        val optionSecond = OptionValidation.validateData(second)
        val optionThird = OptionValidation.validateData(third)
        val optionFourth = OptionValidation.validateData(fourth)

        println(optionFirst)
        println(optionSecond)
        println(optionThird)
        println(optionFourth)

        println()
        println("End Option")
        println()

    }

    fun either() {

        println()
        println("Either")
        println()


        val eitherFirst = EitherValidation.validateData(first)
        val eitherSecond = EitherValidation.validateData(second)
        val eitherThird = EitherValidation.validateData(third)
        val eitherFourth = EitherValidation.validateData(fourth)

        println(eitherFirst)
        println(eitherSecond)
        println(eitherThird)
        println(eitherFourth)

        println()
        println("End Either")
        println()


    }

    fun validated() {

        println()
        println("Validated")
        println()


        val validatedFirst = ValidatedStringValidation.validateData(first)
        val validatedSecond = ValidatedStringValidation.validateData(second)
        val validatedThird = ValidatedStringValidation.validateData(third)
        val validatedFourth = ValidatedStringValidation.validateData(fourth)

        println(validatedFirst)
        println(validatedSecond)
        println(validatedThird)
        println(validatedFourth)

        println()
        println("End Validated")
        println()


    }

}