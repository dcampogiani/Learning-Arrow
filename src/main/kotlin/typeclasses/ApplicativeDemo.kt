package typeclasses

import kategory.*
import success

object ApplicativeDemo {

    operator fun invoke() {

        //demoPure()
        //demoAp()
        //demoMap2()
        //demoMap2Eval()
        //demoApplicativeBuilderOption()
        //demoApplicativeBuilderTry()
        //demoApplicativeBuilderGeneric()
    }

    private fun demoPure() {

        val optionPure = 1.pure<OptionHK, Int>().ev()
        val tryPure = 1.pure<TryHK, Int>().ev()

        println(optionPure)
        println(tryPure)
    }

    private fun demoAp() {

        val optionApOK = 1.some().ap(Option({ n: Int -> n + 1 }))
        val tryFunction = Try.Success({ n: Int -> n + 1 })
        val tryApOK = 1.success().ap(tryFunction)

        val none: Option<(Int) -> Int> = Option.None
        val optionApKO = 1.some().ap(none)

        val failure = Try.Failure<Int>(RuntimeException())
        val tryApKO = failure.ap(tryFunction)


        println(optionApOK)
        println(tryApOK)
        println(optionApKO)
        println(tryApKO)
    }

    private fun demoMap2() {

        val option1 = Option(1)
        val optionX = Option("x")
        val concatString = { z: Tuple2<Int, String> -> "${z.a}${z.b}" }

        val resultBothValid = Option.applicative().map2(option1, optionX, concatString).ev()
        val resultOneIsNone = Option.applicative().map2(Option.None, optionX, concatString).ev()

        println(resultBothValid)
        println(resultOneIsNone)


    }

    private fun demoMap2Eval() {

        val option1 = Option(1)
        val optionX = Option("x")
        val concatString = { z: Tuple2<Int, String> -> "${z.a}${z.b}" }

        val resultBothValid = Option.applicative().map2Eval(option1, Eval.later { optionX }, concatString).ev()

        println(resultBothValid.value())

    }

    private fun demoApplicativeBuilderOption() {

        fun profileService(): Option<String> = Option("Parenzio David")
        fun phoneService(): Option<Int> = Option(339457812)
        fun addressService(): Option<List<String>> = Option(listOf("Via Con la Neve", "40126", "BO"))

        fun phoneServiceInvalid(): Option<Int> = Option.None


        val profileValid = Option.applicative().map(profileService(), phoneService(), addressService()) { (name, phone, address) ->
            Profile(name, phone, address)
        }.ev()

        val profileInValid = Option.applicative().map(profileService(), phoneServiceInvalid(), addressService()) { (name, phone, address) ->
            Profile(name, phone, address)
        }.ev()

        println(profileValid)
        println(profileInValid)

    }

    private fun demoApplicativeBuilderTry() {

        fun profileService(): Try<String> = "Parenzio David".success()
        fun phoneService(): Try<Int> = 339457812.success()
        fun addressService(): Try<List<String>> = listOf("Via Con la Neve", "40126", "BO").success()

        fun phoneServiceInvalid(): Try<Int> = Try.Failure(RuntimeException())


        val profileValid = Try.applicative().map(profileService(), phoneService(), addressService()) { (name, phone, address) ->
            Profile(name, phone, address)
        }.ev()

        val profileInValid = Try.applicative().map(profileService(), phoneServiceInvalid(), addressService()) { (name, phone, address) ->
            Profile(name, phone, address)
        }.ev()

        println(profileValid)
        println(profileInValid)

    }

    private fun demoApplicativeBuilderGeneric() {

        fun profileServiceTry(): Try<String> = "Parenzio David".success()
        fun phoneServiceTry(): Try<Int> = 339457812.success()
        fun addressServiceTry(): Try<List<String>> = listOf("Via Con la Neve", "40126", "BO").success()

        fun phoneServiceInvalidTry(): Try<Int> = Try.Failure(RuntimeException())


        val profileValidTry = createProfile(profileServiceTry(), phoneServiceTry(), addressServiceTry()).ev()
        val profileInValidTry = createProfile(profileServiceTry(), phoneServiceInvalidTry(), addressServiceTry()).ev()

        println(profileValidTry)
        println(profileInValidTry)


        fun profileServiceOption(): Option<String> = "Parenzio David".some()
        fun phoneServiceOption(): Option<Int> = 339457812.some()
        fun addressServiceOption(): Option<List<String>> = listOf("Via Con la Neve", "40126", "BO").some()

        fun phoneServiceInvalidOption(): Option<Int> = Option.None


        val profileValidOption = createProfile(profileServiceOption(), phoneServiceOption(), addressServiceOption()).ev()
        val profileInValidOption = createProfile(profileServiceOption(), phoneServiceInvalidOption(), addressServiceOption()).ev()

        println(profileValidOption)
        println(profileInValidOption)

    }

    private inline fun <reified F> createProfile(profile: HK<F, String>, phone: HK<F, Int>, address: HK<F, List<String>>, FT: Applicative<F> = applicative()): HK<F, Profile> {
        return FT.map(profile, phone, address) { Profile(it.a, it.b, it.c) }
    }

    data class Profile(val name: String, val phone: Int, val address: List<String>)

}