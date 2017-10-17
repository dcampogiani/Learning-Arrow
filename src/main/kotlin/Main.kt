import datatypes.OptionDemo
import datatypes.TryDemo
import kategory.Either
import kategory.Try

fun main(args: Array<String>) {


    val success = TryDemo.parseInt("42").map { TryDemo.multuplyBy2(it) }
    val failure = TryDemo.parseInt("pippo").map { TryDemo.multuplyBy2(it) }

    Try

    print(success)
    print(failure)

}
