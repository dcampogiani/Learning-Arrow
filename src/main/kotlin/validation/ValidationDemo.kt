package validation

import validation.either.EitherValidation
import validation.option.OptionValidation
import validation.validated.ValidatedListStringValidation
import validation.validated.ValidatedNelStringValidation
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

    fun validatedString() {

        println()
        println("Validated String")
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
        println("End Validated String")
        println()

    }

    fun validatedListString() {

        println()
        println("Validated List String")
        println()


        val validatedFirst = ValidatedListStringValidation.validateData(first)
        val validatedSecond = ValidatedListStringValidation.validateData(second)
        val validatedThird = ValidatedListStringValidation.validateData(third)
        val validatedFourth = ValidatedListStringValidation.validateData(fourth)

        println(validatedFirst)
        println(validatedSecond)
        println(validatedThird)
        println(validatedFourth)

        println()
        println("End Validated List String")
        println()

    }

    fun validatedNelString() {

        println()
        println("Validated Nel String")
        println()


        val validatedFirst = ValidatedNelStringValidation.validateData(first)
        val validatedSecond = ValidatedNelStringValidation.validateData(second)
        val validatedThird = ValidatedNelStringValidation.validateData(third)
        val validatedFourth = ValidatedNelStringValidation.validateData(fourth)

        println(validatedFirst)
        println(validatedSecond)
        println(validatedThird)
        println(validatedFourth)

        println()
        println("End Validated Nel String")
        println()

    }

}