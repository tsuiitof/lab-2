
import java.util.Scanner;

public class ComplexNumberArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Вводим размеры массива
        System.out.print("Введите количество строк N: ");
        int N = in.nextInt();
        System.out.print("Введите количество столбцов M: ");
        int M = in.nextInt();
        in.nextLine();  // Считываем оставшийся символ новой строки

        // Создаем двумерный массив для комплексных чисел
        String[][] complexArray = new String[N][M];

        // Считываем элементы массива
        System.out.println("Введите элементы массива в формате a + bi (например, 2 + 5i): ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print("Введите комплексное число для [" + i + "][" + j + "]: ");
                complexArray[i][j] = in.nextLine();
            }
        }

        // 2. Сортировка строк массива по возрастанию модуля комплексных чисел
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    // Получаем вещественную и мнимую части
                    String[] firstComplex = complexArray[i][j].split(" ");
                    String[] secondComplex = complexArray[i][k].split(" ");

                    double real1 = Double.parseDouble(firstComplex[0]);
                    double imaginary1 = Double.parseDouble(firstComplex[2].replace("i", ""));
                    double real2 = Double.parseDouble(secondComplex[0]);
                    double imaginary2 = Double.parseDouble(secondComplex[2].replace("i", ""));

                    // Вычисляем модули
                    double modulus1 = Math.sqrt(real1 * real1 + imaginary1 * imaginary1);
                    double modulus2 = Math.sqrt(real2 * real2 + imaginary2 * imaginary2);

                    // Если модули разные, то сортируем по модулю
                    if (modulus1 > modulus2) {
                        // Меняем местами элементы
                        String temp = complexArray[i][j];
                        complexArray[i][j] = complexArray[i][k];
                        complexArray[i][k] = temp;
                    } else if (modulus1 == modulus2) {
                        // Если модули равны, сравниваем аргументы
                        double arg1 = Math.atan2(imaginary1, real1);
                        double arg2 = Math.atan2(imaginary2, real2);
                        if (arg1 > arg2) {
                            // Меняем местами элементы
                            String temp = complexArray[i][j];
                            complexArray[i][j] = complexArray[i][k];
                            complexArray[i][k] = temp;
                        }
                    }
                }
            }
        }

        // 3. Сумма мнимых частей всех чисел
        double imaginarySum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                String[] parts = complexArray[i][j].split(" ");
                double imaginary = Double.parseDouble(parts[2].replace("i", ""));
                imaginarySum += imaginary;
            }
        }
        System.out.println("Сумма мнимых частей всех чисел: " + imaginarySum);

        // 4. Замена каждого числа на его сопряжённое
        System.out.println("Массив с заменой на сопряжённые числа:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                String[] parts = complexArray[i][j].split(" ");
                double real = Double.parseDouble(parts[0]);
                double imaginary = Double.parseDouble(parts[2].replace("i", ""));

                // Формируем сопряжённое число
                complexArray[i][j] = real + " - " + imaginary + "i";
                System.out.print(complexArray[i][j] + "\t");
            }
            System.out.println();
        }

        // 5. Произведение всех модулей комплексных чисел
        double productOfModuli = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                String[] parts = complexArray[i][j].split(" ");
                double real = Double.parseDouble(parts[0]);
                double imaginary = Double.parseDouble(parts[2].replace("i", ""));

                // Вычисляем модуль
                double modulus = Math.sqrt(real * real + imaginary * imaginary);
                productOfModuli *= modulus;
            }
        }
        System.out.println("Произведение всех модулей комплексных чисел: " + productOfModuli);

        in.close();
    }
}
