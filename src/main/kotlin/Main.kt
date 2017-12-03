import validation.Data
import validation.option.OptionValidation

fun main(args: Array<String>) {

    val first = OptionValidation.validateData(Data("parenzio@gmail.com", "1234567872"))
    val second = OptionValidation.validateData(Data("parenzio.com", "1234567872"))
    val third = OptionValidation.validateData(Data("parenzio@gmail.com", "23"))
    val fourth = OptionValidation.validateData(Data("parenzio.com", "23"))

    println(first)
    println(second)
    println(third)
    println(fourth)
}

