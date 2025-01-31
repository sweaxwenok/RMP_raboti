import java.io.*
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousFileChannel
import java.nio.channels.FileChannel
import java.nio.file.*
import java.nio.file.StandardOpenOption
import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*

// Задача 1: Класс базы данных (Singleton)
class DatabaseConnection private constructor() {
    init {
        println("Создано подключение к базе данных.")
    }

    companion object {
        private var instance: DatabaseConnection? = null

        fun getInstance(): DatabaseConnection {
            if (instance == null) {
                instance = DatabaseConnection()
            }
            return instance!!
        }
    }
}

// Задача 2: Логирование в системе (Singleton)
class Logger private constructor() {
    private val logMessages: MutableList<String> = mutableListOf()

    init {
        println("Инициализирована система логирования.")
    }

    companion object {
        private var instance: Logger? = null

        fun getInstance(): Logger {
            if (instance == null) {
                instance = Logger()
            }
            return instance!!
        }
    }

    fun log(message: String) {
        logMessages.add(message)
    }

    fun printLogs() {
        println("Логи:")
        logMessages.forEach { println(it) }
    }
}

// Задача 3: Реализация статусов заказа
enum class OrderStatus {
    NEW, IN_PROGRESS, DELIVERED, CANCELLED
}

class Order(private var status: OrderStatus) {

    fun changeStatus(newStatus: OrderStatus) {
        when (status) {
            OrderStatus.NEW -> if (newStatus == OrderStatus.IN_PROGRESS || newStatus == OrderStatus.CANCELLED) {
                status = newStatus
            } else {
                println("Невозможно изменить статус.")
            }
            OrderStatus.IN_PROGRESS -> if (newStatus == OrderStatus.DELIVERED || newStatus == OrderStatus.CANCELLED) {
                status = newStatus
            } else {
                println("Невозможно изменить статус.")
            }
            OrderStatus.DELIVERED -> println("Доставленный заказ нельзя отменить.")
            OrderStatus.CANCELLED -> println("Заказ отменен.")
        }
    }

    fun getStatus(): OrderStatus {
        return status
    }
}

// Задача 4: Сезоны года
enum class Season {
    WINTER, SPRING, SUMMER, AUTUMN
}

fun getSeasonName(season: Season): String {
    return when (season) {
        Season.WINTER -> "Зима"
        Season.SPRING -> "Весна"
        Season.SUMMER -> "Лето"
        Season.AUTUMN -> "Осень"
    }
}

// Задание 1: Работа с потоками ввода-вывода
fun copyFileWithUpperCase(sourceFilePath: String, destFilePath: String) {
    try {
        BufferedReader(FileReader(sourceFilePath)).use { reader ->
            BufferedWriter(FileWriter(destFilePath)).use { writer ->
                reader.forEachLine { line ->
                    writer.write(line.uppercase(Locale.getDefault()))
                    writer.newLine()
                }
            }
        }
        println("Файл успешно скопирован и преобразован в верхний регистр.")
    } catch (e: FileNotFoundException) {
        println("Файл не найден: ${e.message}")
    } catch (e: IOException) {
        println("Ошибка при работе с файлом: ${e.message}")
    }
}

// Задание 2: Реализация паттерна Декоратор
interface TextProcessor {
    fun process(text: String): String
}

class SimpleTextProcessor : TextProcessor {
    override fun process(text: String): String = text
}

abstract class TextDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String): String = processor.process(text)
}

class UpperCaseDecorator(processor: TextProcessor) : TextDecorator(processor) {
    override fun process(text: String): String = super.process(text).uppercase(Locale.getDefault())
}

class TrimDecorator(processor: TextProcessor) : TextDecorator(processor) {
    override fun process(text: String): String = super.process(text).trim()
}

class ReplaceDecorator(processor: TextProcessor) : TextDecorator(processor) {
    override fun process(text: String): String = super.process(text).replace(" ", "_")
}

// Задание 3: Сравнение производительности IO и NIO
fun compareIOAndNIO(filePath: String) {
    val startTimeIO = System.currentTimeMillis()
    val contentIO = File(filePath).readText()
    val endTimeIO = System.currentTimeMillis()

    println("Время чтения файла с использованием IO: ${endTimeIO - startTimeIO} мс")

    val startTimeNIO = System.currentTimeMillis()
    val contentNIO = Files.readString(Path.of(filePath))
    val endTimeNIO = System.currentTimeMillis()

    println("Время чтения файла с использованием NIO: ${endTimeNIO - startTimeNIO} мс")
}

// Задание 4: Копирование файла с использованием Java NIO
fun copyFileUsingNIO(sourceFilePath: String, destFilePath: String) {
    try {
        FileChannel.open(Paths.get(sourceFilePath), StandardOpenOption.READ).use { sourceChannel ->
            FileChannel.open(Paths.get(destFilePath), StandardOpenOption.CREATE, StandardOpenOption.WRITE).use { destChannel ->
                sourceChannel.transferTo(0, sourceChannel.size(), destChannel)
            }
        }
        println("Файл успешно скопирован с использованием NIO.")
    } catch (e: IOException) {
        println("Ошибка при копировании файла: ${e.message}")
    }
}

// Задание 5: Асинхронное чтение файла с использованием NIO.2
fun asyncReadFile(filePath: String) {
    val fileChannel = AsynchronousFileChannel.open(Path.of(filePath), StandardOpenOption.READ)

    val buffer = ByteBuffer.allocate(1024)

    fileChannel.read(buffer, 0L, null, object : java.nio.channels.CompletionHandler<Int, Void?> {
        override fun completed(result: Int?, attachment: Void?) {
            if (result != null && result > 0) {
                buffer.flip()
                val content = Charsets.UTF_8.decode(buffer).toString()
                println("Содержимое файла:\n$content")
            } else {
                println("Файл пуст или достигнут конец файла.")
            }
            fileChannel.close()
        }

        override fun failed(exc: Throwable, attachment: Void?) {
            println("Ошибка при чтении файла: ${exc.message}")
            fileChannel.close()
        }
    })
}

// Функции для задач с датами и временем

// Задача #6. Сравнение дат
fun compareDates(date1: LocalDate, date2: LocalDate): String {
    return when {
        date1.isBefore(date2) -> "$date1 меньше $date2"
        date1.isAfter(date2) -> "$date1 больше $date2"
        else -> "$date1 равен $date2"
    }
}

// Задача #7. Сколько дней до Нового года?
fun daysUntilNewYear(): Long {
    val today = LocalDate.now()
    val nextYear = today.year + 1
    val newYear = LocalDate.of(nextYear, Month.JANUARY, 1)

    return ChronoUnit.DAYS.between(today, newYear)
}

// Задача #8. Проверка високосного года
fun isLeapYear(year :Int): Boolean {
    return Year.isLeap(year.toLong())
}

// Задача #9. Подсчет выходных за месяц
fun countWeekends(month :Int ,year :Int): Int {
    var weekendsCount = 0
    val daysInMonth = YearMonth.of(year ,month).lengthOfMonth()

    for (day in 1..daysInMonth) {
        val date = LocalDate.of(year ,month ,day)
        if (date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY) {
            weekendsCount++
        }
    }

    return weekendsCount
}

// Задача #10. Расчет времени выполнения метода
fun measureExecutionTime(block :() -> Unit) {
    val startTime = System.currentTimeMillis()

    block() // Выполнение переданного блока кода

    val endTime = System.currentTimeMillis()

    println("Время выполнения: ${endTime - startTime} мс")
}

// Задача #11. Форматирование и парсинг даты
fun formatAndAddDays(dateString :String ,daysToAdd :Long): String {
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    val date = LocalDate.parse(dateString ,formatter)

    return date.plusDays(daysToAdd).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
}

// Задача #12. Конвертация между часовыми поясами
fun convertTimezone(zonedDateTime :ZonedDateTime ,targetZoneId :String): ZonedDateTime {
    return zonedDateTime.withZoneSameInstant(ZoneId.of(targetZoneId))
}

// Задача #13. Вычисление возраста по дате рождения
fun calculateAge(birthdate :LocalDate): Int {
    return Period.between(birthdate ,LocalDate.now()).years
}

// Задача #14. Создание календаря на месяц
fun printMonthCalendar(month :Int ,year :Int) {
    val daysInMonth = YearMonth.of(year ,month).lengthOfMonth()
    for (day in 1..daysInMonth) {
        val date = LocalDate.of(year ,month ,day)
        val dayType = if (date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY) "Выходной" else "Рабочий день"
        println("$day-$month-$year ($dayType)")
    }
}

// Задача #15. Генерация случайной даты в диапазоне
fun generateRandomDate(startInclusive :LocalDate ,endExclusive :LocalDate): LocalDate {
    return startInclusive.plusDays((0..ChronoUnit.DAYS.between(startInclusive,endExclusive)).random().toLong())
}

// Задача #16. Расчет времени до заданной даты
fun timeUntilEvent(eventDatetime :LocalDateTime): String {
    val now = LocalDateTime.now()
    val duration = Duration.between(now ,eventDatetime)
    return "${duration.toHours()} часов ${duration.toMinutesPart()} минут ${duration.toSecondsPart()} секунд"
}

// Задача #17. Вычисление количества рабочих часов
fun calculateWorkingHours(startWorkDay :LocalDateTime ,endWorkDay :LocalDateTime): Long {
// Здесь можно добавить логику для учета выходных дней.
    var workingHours = Duration.between(startWorkDay,endWorkDay).toHours()
    if (startWorkDay.dayOfWeek == DayOfWeek.SATURDAY || startWorkDay.dayOfWeek == DayOfWeek.SUNDAY) workingHours=0
    return workingHours
}

// Задача #18. Конвертация даты в строку с учетом локали.
fun formatLocalDateWithLocale(date :LocalDate ,locale :Locale): String {
// Форматируем дату в соответствии с локалью.
    return DateTimeFormatter.ofPattern("dd MMMM yyyy",locale).format(date)
}

// Задача #19. Определение дня недели по дате.
fun getDayOfWeekInRussian(date :LocalDate): String{
    return when (date.dayOfWeek) {
        DayOfWeek.MONDAY -> "Понедельник"
        DayOfWeek.TUESDAY -> "Вторник"
        DayOfWeek.WEDNESDAY -> "Среда"
        DayOfWeek.THURSDAY -> "Четверг"
        DayOfWeek.FRIDAY -> "Пятница"
        DayOfWeek.SATURDAY -> "Суббота"
        DayOfWeek.SUNDAY -> "Воскресенье"
    }
}

// Основная функция для тестирования всех задач
fun main() {

    // Проверка Singleton для базы данных
    val db1 = DatabaseConnection.getInstance()
    val db2 = DatabaseConnection.getInstance()
    println("db1 и db2 ссылаются на один и тот же объект: ${db1 === db2}")

    // Логирование
    val logger = Logger.getInstance()
    logger.log("Первое сообщение лога")
    logger.log("Второе сообщение лога")
    logger.printLogs()

    // Статусы заказа
    val order = Order(OrderStatus.NEW)
    println("Текущий статус заказа: ${order.getStatus()}")

    order.changeStatus(OrderStatus.IN_PROGRESS)
    println("Статус после изменения: ${order.getStatus()}")

    order.changeStatus(OrderStatus.DELIVERED)
    println("Статус после изменения: ${order.getStatus()}")

    order.changeStatus(OrderStatus.CANCELLED)

    // Сезоны года
    val currentSeason = Season.SPRING
    println("Текущий сезон: ${getSeasonName(currentSeason)}")

    // Работа с потоками ввода-вывода.
    copyFileWithUpperCase("source.txt", "destination.txt")

    // Паттерн Декоратор.
    val simpleProcessor = SimpleTextProcessor()
    val upperCaseDecorator = UpperCaseDecorator(simpleProcessor)
    val trimDecorator = TrimDecorator(upperCaseDecorator)

    val text = "   Привет, мир!   "

    println("Исходный текст: '$text'")
    println("После декорирования (Trim + UpperCase): '${trimDecorator.process(text)}'")

    // Сравнение производительности IO и NIO.
    compareIOAndNIO("largefile.txt")

    // Копирование файла с использованием Java NIO.
    copyFileUsingNIO("source_large.txt", "destination_large.txt")

    // Асинхронное чтение файла с использованием NIO.2.
    asyncReadFile("source.txt")

    // Проверка дат.
    // Текущая дата и время.
    val currentDate = LocalDate.now()
    val currentTime = LocalTime.now()
    println("Текущая дата: ${currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))} " +
            "${currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"))}")

    // Сравнение дат.
    val date1 = LocalDate.of(2023, 1, 1)
    val date2 = LocalDate.of(2024, 1, 1)
    println(compareDates(date1, date2))

    // Сколько дней до Нового года?
    println("Дней до Нового года: ${daysUntilNewYear()}")

    // Проверка високосного года.
    val yearCheck = 2024
    println("Год $yearCheck является високосным: ${isLeapYear(yearCheck)}")

    // Подсчет выходных за месяц.
    val monthCheck= 1
    println("Количество выходных в месяце $monthCheck за $yearCheck год.: ${countWeekends(monthCheck, yearCheck)}")

    // Измерение времени выполнения метода.
    measureExecutionTime {
        for (i in 1..1_000_000){
            // просто цикл для измерения времени
        }
    }

    // Форматирование и парсинг даты.
    val dateStringCheck= "15-01-2025"
    println("Дата через 10 дней будет равна.: ${formatAndAddDays(dateStringCheck, 10)}")

    // Конвертация между часовыми поясами.
    val utcDateTimeCheck= ZonedDateTime.now(ZoneOffset.UTC)
    println("Время в Europe/Moscow.: ${convertTimezone(utcDateTimeCheck,"Europe/Moscow")}")

    // Вычисление возраста по дате рождения.
    val birthDateCheck= LocalDate.of(1990,5,15)
    println("Возраст.: ${calculateAge(birthDateCheck)} лет.")

    // Создание календаря на месяц.
    printMonthCalendar(1,2025)

    // Генерация случайной даты в диапазоне.
    val randomDateCheck= generateRandomDate(LocalDate.of(2020,1,1),LocalDate.of(2025,12,31))
    println("Случайная дата.: $randomDateCheck")

    // Расчет времени до заданной даты.
    val eventDatetime= LocalDateTime.of(2025,12,31,23,59)
    println("Время до события.: ${timeUntilEvent(eventDatetime)}")

    // Вычисление количества рабочих часов.
    val startWorkDayCheck= LocalDateTime.of(2025,1,15,9,0)
    val endWorkDayCheck= LocalDateTime.of(2025,1,15,17,0)
    println("Количество рабочих часов.: ${calculateWorkingHours(startWorkDayCheck,endWorkDayCheck)}")

    // Конвертация даты в строку с учетом локали.
    println("Форматированная дата.: ${formatLocalDateWithLocale(LocalDate.now(),Locale("ru"))}")

    // Определение дня недели по дате .
    val specificDateCheck= LocalDate.of(2023,10,31)
    println("День недели для $specificDateCheck.: ${getDayOfWeekInRussian(specificDateCheck)}")
}
