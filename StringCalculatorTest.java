import java.util.InputMismatchException;
import java.util.Scanner;

public class StringCalculatorTest {
    static String resultat; // объявляем переменную за методом для доступности в других методах этого класса
    static char stringChar;

    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in); // подключаем сканер
        System.out.println("Можно вводить выражения только следующего вида \"a\" + \"b\", \"a\" - \"b\", \"a\" * y, \"a\" / y " +
                "где a и b - строки, а y - число  от 1 до 10 включительно.");
        String str = scanner.nextLine(); // получаем строку от пользователя
        char[] uchar = new char[26]; // создаем массив символов
        for (int i = 0; i < str.length(); i++) { // Перебераем пока длинна введенного текста не превышена
            uchar[i] = str.charAt(i);           // получаем символ в веденной строке по порядку и помещаем в наш массив
            if (uchar[i] == '+') {              // сравниваем символ
                stringChar = uchar[i];          // заносим в переменную найденый символ
            }
            if (uchar[i] == '-') {
                stringChar = uchar[i];
            }
            if (uchar[i] == '*') {
                stringChar = uchar[i];
            }
            if (uchar[i] == '/') {
                stringChar = uchar[i];
            }
        }
        String[] block = str.split("[+-/*\"]"); // убираем оператор и кавычки (убирает все дефисы не работает "Bye-bye!" - "World!")

        if (block.length == 5) { // определяем что это строки или строка и число
            String сhar01 = block[1];
            String сhar04 = block[4];
            resultat = calc(сhar01, сhar04, stringChar); // выполняем расчет в другом методе для строк
            System.out.println(resultat);
        } else {
            String сhar01 = block[1];
            String сhar03 = block[3].replaceAll(" ", ""); // Убираем пробелы если имеются с числом что бы не упало в ошибку при умножении
            number = Integer.parseInt(сhar03); // Преобразовываем строку в число
            if(number<=10) { // проверяем число не более 10
                resultat = calc(сhar01, number, stringChar); // выполняем расчет в другом методе для строки и числа
                System.out.println(resultat);
            }else System.out.println("Разрешается использовать только числа от 1 до 10.");
        }


    }

    public static String calc(String num1, String num2, char oper) { // метод для расчета "a" + "b" или "a" - "b"

        switch (oper) {
            case '+':
                resultat = num1 + num2;
                break;
            case '-':
                int poz = num1.indexOf(num2);  // находим вхождение в строку
                int poz2 = num1.length();      // позиция 2
                int ind = num2.length();       // получаем длинну вычитаемой строки
                if (poz == 0) {
                    resultat = num1.substring(ind); // если в первой строке нет вхождения второй возвращаем всю строку
                } else {
                    resultat = num1.substring(0,poz)+num1.substring(poz+ind,poz2); // убираем только вхождение второй строки
                }
                break;
            case '*':
                System.out.println("Неверный знак операции * (введите + или -)"); // выводим ошибку по условию задачи
                break;
            case '/':
                System.out.println("Неверный знак операции / (введите + или -)");
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции"); // обрабатываем исключение, что в метод передали недопустимый или несоответствующий параметр
        }
        return resultat;
    }

    public static String calc(String num1, int num2, char oper) { // метод для расчета "a" * "b" или "a" / "b"

        switch (oper) {
            case '+':
                System.out.println("Неверный знак операции + (введите * или /)"); // выводим ошибку по условию задачи
                break;
            case '-':
                System.out.println("Неверный знак операции - (введите * или /)");
                break;
            case '*':
                for (int x = 0; x < num2; x++) { // При умножении строки на число выводит ответ ("a" * 5 = aaaaa)?
                    if (resultat == null) { // проверка для первого значения
                        resultat = num1;
                    }
                    else
                    resultat = resultat + num1;
                }
                break;
            case '/':
                try {
                    int resultB = num1.length() / num2;
                    resultat = num1.substring(0, resultB);
                } catch (ArithmeticException | InputMismatchException e) { // Обрабатываем исключение на double
                    System.out.println("Используйте только целые числа!");
                    break;
                } finally {
                    if (num1.length() < num2) {
                        System.out.println("Делимое значение меньше делителя");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        if (resultat.length() > 40){ // если длинна строки более 40 выводим (...) согласно задаче
            return resultat.substring(0, 40)+" (...)";
        }
        return resultat;
    }
}


