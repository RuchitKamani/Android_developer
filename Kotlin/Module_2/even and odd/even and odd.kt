import java.util.*

class `even and odd` {
    fun evenandodd() {

        val reader = Scanner(System.`in`)

        print("Enter a number: ")
        val num = reader.nextInt()

        if (num % 2 == 0)
            println("$num is even")
        else
            println("$num is odd")
    }
}