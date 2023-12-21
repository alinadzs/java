import java.util.Arrays;
import java.util.Random;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(replaceVovels("apple"));
        System.out.println("_______________________");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println("_______________________");
        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));
        System.out.println("___________________________________________________________________");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println("___________________________________________________________________");
        System.out.println(countRoots(new int[]{1, -3, 2}));
        System.out.println(countRoots(new int[]{2, 5, 2}));
        System.out.println(countRoots(new int[]{1, -6, 9}));
        System.out.println("___________________________________________________________________");
        System.out.println(Arrays.toString(salesData(new String[][]{{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}})));
        System.out.println(Arrays.toString(salesData(new String[][]{{"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}})));
        System.out.println("___________________________________________________________________");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println("___________________________________________________________________");
        System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[]{1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[]{1, 2, -6, 10, 3}));
        System.out.println(waveForm(new int[]{1, 2, -6, 10}));
        System.out.println("___________________________________________________________________");
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println("___________________________________________________________________");
        printArray2(dataScience(new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}}));
        printArray2(dataScience(new int[][]{{6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}}));

    }
    //1
//Метод `replaceVovels(String s)` принимает строку `s` и заменяет все гласные буквы в ней на символ '*'.
    public static String replaceVovels(String s) { //заменяет все гласные буквы на символы
        String vovels = "aeuyioAEUYIO"; // создается строка `vovels`, содержащая все гласные буквы в нижнем и верхнем регистре.
//с помощью цикла `for-each` перебираются все символы из `vovels` и вызывается метод `replace()` для замены каждого гласного символа в `s`.
        for (char v : vovels.toCharArray()) {
            s = s.replace(v, '*');
        }
        return s;
    }
    //2
//Метод принимает строку `s` и выполняет преобразование каждого повторяющегося символа путем добавления слова "Double" перед символом, а не повторяющиеся символы оставляет без изменений.
    public static String stringTransform(String s) {
        StringBuilder fin = new StringBuilder(); //создается объект `StringBuilder` с именем `fin`, в который будут добавляться символы.
        char[] chars = s.toCharArray(); //преобразуется в массив
        int i = 0;
        while (i < chars.length - 1) {
            if (chars[i] == chars[i + 1]) { // если символы равны
                fin.append("Double");
                fin.append(Character.toUpperCase(chars[i])); //символ верхнего регистра
                i = i + 2;
            } else {
                fin.append(chars[i]);
                i++;
            }
        }
        if(chars[chars.length-1] != Character.toLowerCase(fin.charAt(fin.length()-1))){
            fin.append(chars[chars.length - 1]);} //если последний символ в `s` отличается от последнего символа в `fin`, то он добавляется в `fin`
        return fin.toString();
    }
    //3
//Метод `doesBlockFit(int a, int b, int c, int w, int h)` принимает размеры трех блоков (`a`, `b`, `c`) и размеры прямоугольной области (`w`, `h`).
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= w && c <= h) || (b <= w && c <= h) || (b <= w && a <= h) || (c <= w && a <= h) || (c <= w && b <= h);
    }
    //4
//Метод `numCheck(int a)` принимает целое число `a` и вычисляет сумму квадратов его цифр.
    public static boolean numCheck(int a) {
        int sum = 0;
        int b = a;
//является ли модуль `b` (исходное число) по модулю 2 равным остатку от деления суммы квадратов на 2.
        while (a != 0) {
            sum += (int) Math.pow(a % 10, 2);
            a = a / 10;
        }
        return b % 2 == sum % 2;
    }
    //5
//Метод `countRoots(int[] c)` принимает массив целых чисел `c`, представляющий квадратное уравнение вида `ax^2 + bx + c = 0`.
    public static int countRoots(int[] c) {
        int d = c[1] * c[1] - 4 * c[0] * c[2];
//если `d > 0`, то уравнение имеет два корня,
        if (d > 0) {
            return 2;
//если `d == 0`, то уравнение имеет один корень,
        } else if (d == 0) {
            return 1;
//если `d < 0`, то уравнение не имеет действительных корней.
        } else return 0;
    }
    //6
//Метод `salesData` принимает двумерный массив `mas`, представляющий информацию о продажах различных товаров в разных магазинах.
    public static String[] salesData(String[][] mas) {
        Set<String>uniqShopName = new HashSet<>(); //Метод находит уникальные названия магазинов, используя HashSet
//есть ли у каждого товара такое же количество магазинов, какое общее количество уникальных названий магазинов. Если да, то добавляет название товара в результат.
        for (String[] productInfo : mas) {
            for (int i = 1; i < productInfo.length; ++i) {
                uniqShopName.add(productInfo[i]);
            }
        }

        List<String>result = new ArrayList<>();
        for (String[] productInfo : mas) {
            if (productInfo.length - 1 == uniqShopName.size()) {
                result.add(productInfo[0]);
            }
        }

        return result.toArray(new String[0]);
    }
    //7
//Метод `validSplit` принимает строку `s` и разделяет ее на слова.
    public static boolean validSplit(String s) {
        String[] words = s.split(" ");
//последняя буква каждого слова равна первой букве следующего слова.
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                return false;
            }
        }
        return true;
    }
    //8
//Метод `waveForm` принимает одномерный массив `mas` и проверяет, является ли он "волнообразным".
    public static boolean waveForm(int[] mas) {
        boolean fin = true;
//Волнообразный массив - это такой массив, в котором каждое значение на нечетных индексах больше предыдущего значения, а каждое значение на четных индексах меньше следующего значения.
// 2>1<2>1<2
        for (int i = 1; i < mas.length; i += 2) {
            if (mas[i - 1] < mas[i]) {
                fin = false;
                break;
            }

            if (i != mas.length - 1 && mas[i + 1] < mas[i]) {
                fin = false;
                break;
            }
        }

        if (fin) {
            return fin;
        }
        fin = true;

// 1<2>1<2>1
        for (int i = 1; i < mas.length; i += 2) {
            if (mas[i - 1] > mas[i]) {
                fin = false;
                break;
            }

            if (i != mas.length - 1 && mas[i + 1] > mas[i]) {
                fin = false;
                break;
            }
        }

        return fin;
    }
    //9
//Метод `commonVovel` принимает строку `s` и находит самую часто встречающуюся гласную букву в ней.
    public static char commonVovel(String s) {
        String vol = "aeuyio";
        int max = 0;
        char fin = 'a';
//проходит по каждой гласной букве (a, e, u, y, i, o) и подсчитывает количество ее повторений в строке.
        for (char ch : vol.toCharArray()) {
            int c = 0;
            for (char sim : s.toLowerCase().toCharArray()) {
                if (sim == ch) {
                    c++;
                }
            }
            if (c > max) {
                max = c;
                fin = ch;
            }
        }
        return fin;
    }
    //10
//Метод `dataScience` принимает двумерный массив `mas`, представляющий данные в области науки о данных.
    public static int[][] dataScience(int[][] mas){
        for (int i = 0; i < mas.length; i++) { //вычисляет среднее значение каждого столбца
            int sum = 0;
//заменяет значение в каждой ячейке столбца на разницу между суммой столбца и этим средним значением, деленной на количество строк минус одна.
            for (int j = 0; j < mas.length; j++) {
                sum += mas[j][i];
            }
            mas[i][i] = Math.round((float) (sum - mas[i][i]) / (mas.length-1));
        }
        return mas;
    }

    //функция не относиться к заданию, была сделана только для более легкого вывода двумерного массива
    private static void printArray2(int[][] mas){
        System.out.println("[");
        for (int[] m:mas) {
            System.out.println(Arrays.toString(m));
        }
        System.out.println("]");
    }
}