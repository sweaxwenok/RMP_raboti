import kotlin.math.pow

fun main() {
    println("Введите целое число:")
    val number = readLine()!!.toInt()
    if (number % 2 == 0) {
        println("$number - четное число.")
    } else {
        println("$number - нечетное число.")
    }

    println("Введите три целых числа:")
    val a4 = readLine()!!.toInt()
    val b4 = readLine()!!.toInt()
    val c4 = readLine()!!.toInt()
    val min = minOf(a4, b4, c4)
    println("Минимальное число: $min")

    println("Таблица умножения на 5:")
    for (i in 1..10) {
        println("5 * $i = ${5 * i}")
    }
    println("Введите целое число N:")
    val n = readLine()!!.toInt()
    val sum = (1..n).sum()
    println("Сумма чисел от 1 до $n: $sum")

    println("Введите целое число N:")
    val n2 = readLine()!!.toInt()
    var a2 = 0
    var b2 = 1
    println("Первые $n чисел Фибоначчи:")
    for (i in 1..n2) {
        print("$a2 ")
        val next = a2 + b2
        a2 = b2
        b2 = next
    }
    println("Введите целое число для проверки на простоту:")
    val primeCandidate = readLine()!!.toInt()
    val isPrime = primeCandidate > 1 && (2 until primeCandidate).none { primeCandidate % it == 0 }
    println("$primeCandidate ${if (isPrime) "является" else "не является"} простым числом.")

    if (isPrime) {
        println("$number - простое число.")
    } else {
        println("$number - не простое число.")
    }

    println("Введите целое число N:")
    val n1 = readLine()!!.toInt()

    for (i in n1 downTo 1) {
        print("$i ")
    }

    println("Введите два целых числа A и B:")
    val a5 = readLine()!!.toInt()
    val b5 = readLine()!!.toInt()

    val sumEven = (a5..b5).filter { it % 2 == 0 }.sum()

    println("Сумма четных чисел от $a5 до $b5: $sumEven")

    println("Введите строку:")
    val inputString = readLine()!!
    val reversedString = inputString.reversed()
    println("Обратная строка: $reversedString")

    println("Введите целое число:")
    val number1 = readLine()!!

    println("Количество цифр в числе: ${number1.length}")

    println("Введите целое число N:")
    val n5 = readLine()!!.toInt()

    fun factorial(n5: Int): Long {
        return if (n5 <= 1) 1 else n5 * factorial(n5 - 1)
    }

    println("Факториал числа $n5: ${factorial(n5)}")
    println("Введите целое число:")
    val number2 = readLine()!!

    val sumOfDigits = number2.map { it.toString().toInt() }.sum()

    println("Сумма цифр числа: $sumOfDigits")
    println("Введите строку:")
    val inputString1 = readLine()!!

    if (inputString1 == inputString1.reversed()) {
        println("$inputString1 - палиндром.")
    } else {
        println("$inputString1 - не палиндром.")
    }

    println("Введите размер массива:")
    val size = readLine()!!.toInt()

    val numbers = IntArray(size)

    for (i in numbers.indices) {
        println("Введите элемент массива ${i + 1}:")
        numbers[i] = readLine()!!.toInt()
    }

    val maxNumber = numbers.maxOrNull()

    println("Максимальное число в массиве: $maxNumber")
    println("Введите размер массива:")
    val size1 = readLine()!!.toInt()

    val numbers1 = IntArray(size)

    for (i in numbers1.indices) {
        println("Введите элемент массива ${i + 1}:")
        numbers1[i] = readLine()!!.toInt()
    }

    val totalSum = numbers1.sum()

    println("Сумма всех элементов массива: $totalSum")



    println("Введите размер массива:")
    val size2 = readLine()!!.toInt()

    val numbers2 = IntArray(size)

    for (i in numbers2.indices) {
        println("Введите элемент массива ${i + 1}:")
        numbers2[i] = readLine()!!.toInt()
    }

    val positiveCount = numbers2.count { it > 0 }
    val negativeCount = numbers2.count { it < 0 }

    println("Количество положительных чисел: $positiveCount")
    println("Количество отрицательных чисел: $negativeCount")

    println("Введите два целых числа A и B:")
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()

    fun isPrime(num: Int): Boolean {
        if (num < 2) return false
        for (i in 2 until num) {
            if (num % i == 0) return false
        }
        return true
    }

    val primesInRange = (a..b).filter { isPrime(it) }

    println("Простые числа в диапазоне от $a до $b: $primesInRange")
    println("Введите строку:")
    val inputString2 = readLine()?.lowercase()?.replace(Regex("[^a-z]"), "") ?: ""

    val vowelsCount = inputString2.count { it in "aeiou" }
    val consonantsCount = inputString2.length - vowelsCount

    println("Количество гласных букв: $vowelsCount")
    println("Количество согласных букв: $consonantsCount")

    println("Введите строку, состоящую из нескольких слов:")
    val inputString3 = readLine()?.trim()

    if (!inputString3.isNullOrEmpty()) {
        val reversedWordsString = inputString3.split(' ').reversed().joinToString(" ")
        println("Перестановка слов в обратном порядке: $reversedWordsString")
    } else {
        println("Введена пустая строка.")
    }

    println("Введите целое число:")
    val numberStr = readLine()!!
    val number6 = numberStr.toInt()

    val numDigits = numberStr.length
    val armstrongSum = numberStr.map { it.toString().toInt().pow(numDigits) }.sum()

    if (armstrongSum == number) {
        println("$number6 - это число Армстронга.")
    } else {
        println("$number6 - это не число Армстронга.")
    }
}

private fun Int.pow(exp: Int): Int =
    this.toDouble().pow(exp).toInt()