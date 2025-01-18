import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args){

        // Считывание размеров массива
        out.print("Введите количество строк N: "); // Запрос количества строк
        int N = in.nextInt(); // Считывание количества строк
        out.print("Введите количество столбцов M: "); // Запрос количества столбцов
        int M = in.nextInt(); // Считывание количества столбцов
        in.nextLine(); // Очистка буфера после считывания чисел

        // Создание двумерных массивов для хранения действительных и мнимых частей
        double[][] realPart = new double[N][M]; // действительная часть
        double[][] imagPart = new double[N][M]; // мнимая часть

        // 1. Считывание элементов массива
        out.println("Введите элементы массива (формат a + bi):"); // Инструкция пользователю
        for (int i = 0; i < N; i++) { // Проход по строкам массива
            for (int j = 0; j < M; j++) { // Проход по столбцам массива
                out.println("Введите комплексное число для позиции (" + i + ", " + j + "): "); // Запрос значения для конкретного элемента
                out.print("Действительная часть: ");
                realPart[i][j] = in.nextDouble(); // Считывание действительной части
                in.nextLine();
                out.print("Мнимая часть: ");
                imagPart[i][j] = in.nextDouble(); // Считывание мнимой части
                in.nextLine();
            }
        }

        // 2. Сортировка строк массива по возрастанию модуля и аргумента
        for (int i = 0; i < N; i++) { // Проход по каждой строке массива
            for (int j = 0; j < M - 1; j++) { // Внешний цикл для сортировки элементов строки
                for (int k = j + 1; k < M; k++) { // Внутренний цикл для сравнения элементов
                    // Модуль и аргумент для сравнения
                    double mod1 = Math.sqrt(realPart[i][j] * realPart[i][j] + imagPart[i][j] * imagPart[i][j]); // Модуль первого числа
                    double mod2 = Math.sqrt(realPart[i][k] * realPart[i][k] + imagPart[i][k] * imagPart[i][k]); // Модуль второго числа
                    double arg1 = Math.atan2(imagPart[i][j], realPart[i][j]); // Аргумент первого числа
                    double arg2 = Math.atan2(imagPart[i][k], realPart[i][k]); // Аргумент второго числа

                    // Сравнение по модулю, а затем по аргументу, если модули равны
                    if (mod1 > mod2 || (mod1 == mod2 && arg1 > arg2)) {
                        // Меняем элементы местами, если порядок нарушен
                        double tempReal = realPart[i][j]; // Временная переменная для действительной части
                        double tempImag = imagPart[i][j]; // Временная переменная для мнимой части
                        realPart[i][j] = realPart[i][k]; // Перестановка действительных частей
                        imagPart[i][j] = imagPart[i][k]; // Перестановка мнимых частей
                        realPart[i][k] = tempReal; // Завершение обмена
                        imagPart[i][k] = tempImag; // Завершение обмена
                    }
                }
            }
        }

        // 3. Сумма мнимых частей всех чисел в массиве
        double imagSum = 0; // Переменная для хранения суммы мнимых частей
        for (int i = 0; i < N; i++) { // Проход по строкам массива
            for (int j = 0; j < M; j++) { // Проход по столбцам массива
                imagSum += imagPart[i][j]; // Добавление мнимой части текущего числа к сумме
            }
        }
        out.println("Сумма мнимых частей: " + imagSum); // Вывод суммы мнимых частей

        // 4. Вывод элементов массива, заменяя их на сопряженные числа
        out.println("Массив после замены на сопряженные числа:"); // Сообщение о начале вывода сопряжённых чисел
        for (int i = 0; i < N; i++) { // Проход по строкам массива
            for (int j = 0; j < M; j++) { // Проход по столбцам массива
                // Действительная часть остается неизменной
                double real = realPart[i][j];
                // Мнимая часть: меняем знак
                double imaginary = -imagPart[i][j];
                out.print(real + "" + imaginary + "i  ");
                }
            }
            out.println(); // Переход на новую строку

        // 5. Произведение всех модулей комплексных чисел
        double modProduct = 1; // Переменная для хранения произведения модулей
        for (int i = 0; i < N; i++) { // Проход по строкам массива
            for (int j = 0; j < M; j++) { // Проход по столбцам массива
                double mod = Math.sqrt(realPart[i][j] * realPart[i][j] + imagPart[i][j] * imagPart[i][j]); // Вычисление модуля текущего числа
                modProduct *= mod; // Умножение модуля на общее произведение
            }
        }
        out.println("Произведение всех модулей: " + modProduct); // Вывод произведения модулей
    }
}
