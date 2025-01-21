## Отчет по лабораторной работе № 2

#### № группы: `ПМ-2402`

#### Выполнила: `Соколовская Снежана Владимировна`

#### Вариант: `22`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм и математическая модель](#4-алгоритм-и-математическая-модель)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> Напишите программу на Java, которая выполняет следующие действия
с двумерным массивом комплексных чисел:

1. Считывает с консоли размеры массива N и M, затем элементы
массива размером N×M, где каждый элемент — комплексное число
в формате a + bi.
2. Сортирует строки массива по возрастанию модуля комплексных чисел в строке. Если модули равны, сравнивает аргументы чисел.
3. Находит и выводит сумму всех мнимых частей чисел в массиве.
4. Выводит элементы массива, заменяя каждое комплексное число на
его сопряжённое.
5. Вычисляет и выводит произведение всех модулей комплексных чисел в массиве.

- Для первой задачи необходимо запросить у пользователя размеры массива N (число строк) и M (число столбцов); создать два двумерных массива для хранения - действительных частей комплексных чисел и мнмых частей комплексных чисел; ввести элементы массива в формате 𝑎 + 𝑏𝑖, где: 𝑎 — действительная часть, 𝑏 — мнимая часть.
- Для второй задачи будем для каждой строки сначала вычислять модуль каждого числа и, если модули равны, сравниваем их аргументы - число с меньшим аргументом должно идти раньше. Далее применяем сортировку пузырьком, чтобы переставить числа по правилам.
- Для третьей задачи пройдемся по всем элементам массива и сложим все мнимые части чисел (𝑏).
- Для четверной задачи для каждого числа в массиве заменим мнимую часть (𝑏) на противоположное значение (−𝑏). Выведем массив, где каждое число представлено в формате 𝑎 −𝑏𝑖.
- Для пятой задачи для каждого числа в массиве вычислим его модуль и затем перемножим все модули.

### 2. Входные и выходные данные

#### Данные на вход

На вход программа должна получать 2 целых числа N и M. Но так как эти числа задают количество строк и столбцов в двумерном массиве, то они не могут принимать неположительные значения. Так как нам не указали диапазон, то сделаем его самостоятельно, при котором минимальное значение N и M будет 1. Максимальное значение - 2^31. 

|                | Тип                  | min значение    | max значение   |
|----------------|----------------------|-----------------|----------------|
| realPart[i][j] | Действительное число | -10<sup>9</sup> | 10<sup>9</sup> |
| imagPart[i][j] | Действительное число | -10<sup>9</sup> | 10<sup>9</sup> |
| N (Число 1)    | Целое число          |        1        | 2<sup>31</sup> |
| M (Число 2)    | Целое число          |        1        | 2<sup>31</sup> |

#### Данные на выход

Программа делает 3 выхода: сумма мнимых частей всех комплексных чисел в массиве, массив, где для каждого комплексного числа меняется знак мнимой части, произведение модулей всех чисел в массиве. Модуль комплексного числа всегда положителем, поэтому минимальное значение - 0 (если хотя бы одно комплексное число в массиве имеет нулевой модуль). Так как значения массива после заамены на сопряженные числа зависят от ввода, минимальные и максимальные значения могут быть как положительными, так и отрицательными в зависимости от ввода.

|                        | Тип                           | min значение              | max значение              |
|------------------------|-------------------------------|---------------------------|---------------------------|
|      imagSum           | Действительное число (double) |-10<sup>9</sup> * N * M    | 10<sup>9</sup> * N * M    |
|      modProduct        | Действительное число (double) |                          | 2<sup>31</sup>            |
| Массив после замены на | Строка(String)                | зависит от действительных | зависит от действительных |
| сопряженные числа      |                               | и мнимых частей           | и мнимых частей           |
                                        

### 3. Выбор структуры данных

Программа получает 2 целых числа, N и M, значения которых мы указали ранее. Для их хранения будем использовать переменные (N;M) типа int. Тип double я используя для массивов realPart и imagPart, так как комплексные числа могут иметь дробные значения. Для хранения промежуточных результатов (суммы мнимых частей, произведения модулей) также используется тип double, так как эти значения могут быть вещественными числами. Тип String выбран для вывода сопряженных чисел, так как для представления комплексных чисел удобнее использовать строковый формат.

| название переменной                 | Тип (в Java) | 
|-------------------------------------|--------------|
| `N`                                 | `int`        |
| `M`                                 | `int`        | 
| `realPart[i][j]`                    | `double[][]` |
| `imagPart[i][j]`                    | `double[][]` |
| `imagSum`                           | `double`     |
| `modProduct`                        | `double`     |
| `tempReal`                          | `double`     |
| `tempImag`                          | `double`     |
|Строки для вывода (сопряженные числа)| `String`     |


### 4. Алгоритм

**Математическая модель:**
Программа работает с двумерным массивом комплексных чисел. Мы моделируем операцию с комплексными числами, такими как сортировка по модулю и аргументу, замена чисел на их сопряженные значения, а также суммирование мнимых частей и вычисление произведения модулей.
1. Массив комплексных чисел: Каждый элемент массива представляет собой комплексное число, которое имеет два компонента: действительную и мнимую части. Комплексное число в позиции массива a[i][j] может быть записано как: a[i][j]=realPart[i][j]+imagPart[i][j]i, где realPart[i][j] — это действительная часть, а imagPart[i][j] — мнимая часть числа.
2. Модуль комплексного числа: Модуль комплексного числа a = a1+a2i вычисляется по формуле: |a| = sqrt(a1<sup>2+a2<sup>2)
где 𝑎1 — действительная часть, а 𝑎2 — мнимая часть числа.







### 5. Программа

```java
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
