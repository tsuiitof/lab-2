import java.io.PrintStream;
import java.util.Scanner;
public class whilebb {
    // Объявляем объект класса Scanner для ввода данных
    public static Scanner in = new Scanner(System.in);
    // Объявляем объект класса PrintStream для вывода данных
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        // Считывание четырех целых чисел x, y, w и z из консоли
        int x = in.nextInt();
        int y = in.nextInt();
        int w = in.nextInt();
        int z = in.nextInt();
        // Задаем диапазон допустимых значений (минимум и максимум)
        int min = -(int)Math.pow(10, 9);
        int max = (int)Math.pow(10, 9);
        // Проверяем, войдет ли число в заданный диапазон
        if (x <= min || x >= max || y<= min || y>=max ||w<= min || w>=max ||z<= min || z>=max) {
            out.println("Среди введённых чисел есть числ(о/а), не входящ(и/е)е в заданный диапазон `-10^9 <= ваше число <= 10^9`. " +
                    "\nВведите четыре числа, каждое из которых будет входить в диапазон допустимых значений.");
            x = in.nextInt();
            y = in.nextInt();
            w = in.nextInt();
            z = in.nextInt();
        }
        // Рассмотрим первый случай, когда x<y
        if (x<y)
            // Далее проверяем остальные условия, варианты которые сейчас могут быть: xywz,xyzw,xwzy,xwyz,xzyw,xzwy,zxyw,zxwy,zwxy,wzxy,wxyz,wxzy. (Далее в комментариях будут написаны возможные варианты расстановок)
            if (y < w)
                // xywz,xyzw,zxyw,xzyw
                if (w < z)
                    // xYwz
                    out.print(y);
                else
                    // xyzw,xzyw,zxyw
                    if (y < z)
                        // xYzw
                        out.print(y);
                    else
                        // xzyw,zxyw
                        if (x < z)
                            // xZyw
                            out.print(z);
                        else
                            // zXyw
                            out.print(x);
            else
                // xwyz,xwzy,zxwy,wxzy,wzxy,zwxy,xzwy
                if (x<w)
                    // xwyz,xwzy,xzwy,zxwy
                    if (z<x)
                        // zXwy
                        out.print(x);
                    else
                        //xwyz,xwzy,xzwy
                        if (z<w)
                            // xZwy
                            out.print(z);
                        else
                            // xWyz,xWzy
                            out.print(w);
                else
                    // wxyz,wxzy,wzxy,zwxy
                    if (z<w)
                        // zWxy
                        out.print(w);
                    else
                    if (z<x)
                        // wZxy
                        out.print(z);
                    else
                        // wXyz, wXzy
                        out.print(x);
            // Второй случай: x>y
        else
            // Также проверяем остальные условия: yxwz,yxzw,ywxz,ywzx,yzxw,yzwx,zywx,zyxw,zwyx,wzyx,wyxz,wyzx
            if (w<y)
                // wzyx,zwyx,xyzx,wyxz
                if (z<w)
                    // zWyx
                    out.print(w);
                else
                    // wzyx,wyzx,wyxz
                    if (z<y)
                        // wZyx
                        out.print(z);
                    else
                        // wYzx,wYxz
                        out.print(y);
            else
                // yxwz,yxzw,yzxw,zyxw,ywxz,ywzx,yzwx,zywx
                if (w<x)
                    // ywxz,ywzx,yzwx,zywx
                    if (x<z)
                        // yWxz
                        out.print(w);
                    else
                        // ywzx,yzwx,zywx
                        if (w<z)
                            // yWzx
                            out.print(w);
                        else
                            // ywzx,yzwx,zywx
                            if (z<y)
                                // zYwx
                                out.print(y);
                            else
                                // yZwx
                                out.print(z);
                else
                    // yxwz,yxzw,yzxw,zyxw
                    if (z<y)
                        // zYxw
                        out.print(y);
                    else
                        // yxwz,yxzw,yzxw
                        if (z<x)
                            // yZxw
                            out.print(z);
                        else
                            // yXwz,yXzw
                            out.print(x);
    }
}