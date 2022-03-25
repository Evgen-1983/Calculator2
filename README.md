# Calculator2

Задача: программа "Строковый калькулятор"
Описание:
Создайте консольное приложение "Строковый калькулятор". Приложение должно читать из консоли введенные пользователем строки, числа, арифметические операции проводимые между ними и выводить в консоль результат их выполнения.

Требования:
Калькулятор умеет выполнять операции сложения строк, вычитания строки из строки, умножения строки на число и деления строки на число: "a" + "b", "a" - "b", "a" * b, "a" / b. Данные передаются в одну строку(смотрите пример)! Решения, в которых каждая строка, число и арифмитеческая операция передаются с новой строки считаются неверными.
Значения строк передаваемых в выражении выделяются двойными кавычками.
Результатом сложения двух строк, является строка состоящая из переданных.
Результатом деления строки на число n, является строка в n раз короче исходной (смотрите пример).
Результатом умножения строки на число n, является строка, в которой переданная строка повторяется ровно n раз.
Результатом вычитания строки из строки, является строка, в которой удалена переданная подстрока или сама исходная строка, если в нее нет вхождения вычитаемой строки (смотрите пример).
Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. И строки длинной не более 10 символов. Если строка, полученная в результате работы приложения длинее 40 симовлов, то в выводе после 40 символа должны стоять три точки (...)
Калькулятор умеет работать только с целыми числами.
Первым аргументом выражения, подаваемого на вход, должна быть строка, при вводе пользователем выражения вроде 3 + "hello", калькулятор должен выбросить исключение и прекратить свою работу.
При вводе пользователем неподходящих чисел, строк или неподдерживаемых операций (например, деление строки на строку) приложение выбрасывает исключение и завершает свою работу.
При вводе пользователем выражения, не соответствующего одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.
Пример работы программы:
Input:
"100" + "500"

Output:
"100500"

Input:
"Hi World!" - "World!"

Output:
"Hi "

Input:
"Bye-bye!" - "World!"  - Этот пример в данном калькуляторе не работает!

Output:
"Bye-bye!"

Input:
"Java" * 5

Output:
"JavaJavaJavaJavaJava"

Input:
"Example!!!" / 3

Output:
"Exa"
