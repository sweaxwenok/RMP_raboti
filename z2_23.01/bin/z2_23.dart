import 'dart:math' as Math;

// 1. Функция для нахождения максимума
int findMax(int a, int b) {
  if (a == b) {
    throw Exception("Числа равны.");
  }
  return (a > b) ? a : b;
}
// 2. Калькулятор деления
double divide(double numerator, double denominator) {
  if (denominator == 0) {
    throw Exception("Недопустимо деление на ноль.");
  }
  return numerator / denominator;
}

// 3. Конвертер строк в числа
int stringToInt(String str) {
  try {
    return int.parse(str);
  } catch (e) {
    throw FormatException("Невозможно конвертировать строку в целое число.");
  }
}

// 4. Проверка возраста
void checkAge(int age) {
  if (age < 0 || age > 150) {
    throw ArgumentError("Возраст должен быть в диапазоне от 0 до 150.");
  }
}

// 5. Нахождение корня
double squareRoot(double number) {
  if (number < 0) {
    throw ArgumentError("Невозможно найти корень из отрицательного числа.");
  }
  return Math.sqrt(number);
}

// 6. Факториал
int factorial(int n) {
  if (n < 0) {
    throw Exception("Факториал не определен для отрицательных чисел.");
  }
  return n == 0 ? 1 : n * factorial(n - 1);
}

// 7. Проверка массива на нули
void checkArrayForZeros(List<int> array) {
  if (array.contains(0)) {
    throw Exception("Массив содержит нули.");
  }
}

// 8. Калькулятор возведения в степень
double power(double base, int exponent) {
  if (exponent < 0) {
    throw Exception("Степень не может быть отрицательной.");
  }
  return Math.pow(base, exponent).toDouble();
}

// 9. Обрезка строки
String trimString(String str, int length) {
  if (length > str.length) {
    throw Exception("Число символов больше длины строки.");
  }
  return str.substring(0, length);
}

//10. Поиск элемента в массиве
int findElementInArray(List<int> array, int element) {
  int index = array.indexOf(element);
  if (index == -1) {
    throw Exception("Элемент не найден в массиве.");
  }
  return index;
}

//11. Конвертация в двоичную систему
String convertToBinary(int number) {
  if (number < 0) {
    throw Exception("Отрицательные числа не могут быть конвертированы в двоичную систему.");
  }
  return number.toRadixString(2);
}

//12. Проверка делимости
bool isDivisible(int a, int b) {
  if (b == 0) {
    throw Exception("Недопустимо деление на ноль.");
  }
  return a % b == 0;
}

//13. Чтение элемента списка
T getElementFromList<T>(List<T> list, int index) {
  if (index < 0 || index >= list.length) {
    throw IndexError(index, list);
  }
  return list[index];
}

//14. Парольная проверка
void checkPasswordStrength(String password) {
  if (password.length < 8) {
    throw Exception("Пароль слишком слабый, должен содержать не менее 8 символов.");
  }
}

//15. Проверка даты
void checkDateFormat(String dateStr) {
  try {
    DateTime.parse(dateStr);
  } catch (e) {
    throw FormatException("Некорректный формат даты. Ожидается 'dd.MM.yyyy'.");
  }
}

//16. Конкатенация строк
String concatenateStrings(String? str1, String? str2) {
  if (str1 == null || str2 == null) {
    throw Exception("Одна из строк равна null.");
  }
  return str1 + str2;
}

//17. Остаток от деления
int remainder(int a, int b) {
  if (b == 0) {
    throw Exception("Недопустимо деление на ноль.");
  }
  return a % b;
}

//18. Квадратный корень
double squareRootFunction(double number) {
  if (number < 0) {
    throw ArgumentError("Невозможно найти квадратный корень из отрицательного числа.");
  }
  return Math.sqrt(number);
}

//19. Конвертер температуры
double celsiusToFahrenheit(double celsius) {
  const double absoluteZeroCelsius = -273.15;
  if (celsius < absoluteZeroCelsius) {
    throw Exception("Температура ниже абсолютного нуля.");
  }
  return celsius * (9 / 5) + 32;
}

//20. Проверка строки на пустоту
void checkStringIsEmpty(String? str) {
  if (str == null || str.isEmpty) {
    throw Exception("Строка пустая или равна null.");
  }
}

void main() {
  try {
    print('Максимум из чисел (5 и 3): ${findMax(5,3)}');
  } catch(e) { print(e); }

  try {
    print('Результат деления (10 / 2): ${divide(10,2)}');
  } catch(e) { print(e); }

  try {
    print('Строка "123" конвертирована в число: ${stringToInt("123")}');
  } catch(e) { print(e); }

  try {
    checkAge(25);
    print('Возраст корректен: 25');
  } catch(e) { print(e); }

  try {
    print('Квадратный корень из числа (16): ${squareRoot(16)}');
  } catch(e) { print(e); }

  try {
    print('Факториал числа (5): ${factorial(5)}');
  } catch(e) { print(e); }

  try {
    List<int> array = [1,2,3];
    checkArrayForZeros(array);
    print('Массив [1,2,3] не содержит нулей.');
  } catch(e) { print(e); }

  try {
    print('Возведение в степень (2^3): ${power(2,3)}');
  } catch(e) { print(e); }

  try {
    print('Обрезанная строка "Hello World" до первых пяти символов: "${trimString("Hello World",5)}"');
  } catch(e) { print(e); }

  try {
    List<int> array = [1,2,3];
    print('Индекс элемента "2" в массиве [1,2,3]: ${findElementInArray(array,2)}');
  } catch(e) { print(e); }

  try {
    print('Двоичное представление числа "10": ${convertToBinary(10)}');
  } catch(e) { print(e); }

  try {
    print('Проверка делимости (10 на 2): ${isDivisible(10,2)}');
  } catch(e) { print(e); }

  try {
    List<String> list = ['a', 'b', 'c'];
    print('Элемент списка по индексу "1": ${getElementFromList(list,1)}');
  } catch(e) { print(e); }

  try {
    checkPasswordStrength('mypassword');
    print('Пароль "mypassword" достаточно сильный.');
  } catch(e) { print(e); }

  try {
    checkDateFormat('15.01.2025');
    print('Дата "15.01.2025" корректна.');
  } catch(e) { print(e); }

  try {
    String result = concatenateStrings('Hello', 'World');
    print('Конкатенация строк "Hello" и "World": $result');
  } catch(e) { print(e); }

  try {
    print('Остаток от деления (10 % 3): ${remainder(10,3)}');
  } catch(e) { print(e); }

  try {
    print('Квадратный корень из числа (25): ${squareRootFunction(25)}');
  } catch(e) { print(e); }

  try {
    print('Температура в Фаренгейтах при Цельсии "25": ${celsiusToFahrenheit(25)}');
  } catch(e) { print(e); }

  try {
    checkStringIsEmpty('');
    print('Строка не пустая.');
  } catch(e) { print(e); }
}
