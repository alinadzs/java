import java.util.Arrays;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Doonal"));
        System.out.println(duplicateChars("orange"));
        System.out.println("_______________________");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println("_______________________");
        System.out.println(differenceEvenOdd(new int[]{44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55}));
        System.out.println("_______________________");
        System.out.println(equalToAvg(new int[]{1, 2, 3, 4, 5}));
        System.out.println(equalToAvg(new int[]{1, 2, 3, 4, 6}));
        System.out.println("_______________________");
        System.out.println((indexMult(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(indexMult(new int[]{3, 3, -2, 408, 3, 31})));
        System.out.println("________________________");
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println("________________________");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println("________________________");
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(7));
        System.out.println(pseudoHash(0));
        System.out.println("________________________");
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println("________________________");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));

    }
    public static boolean duplicateChars(String str) {
        str = str.toLowerCase(); //строка стр переводится в нижний регистр с помощью метода ...
        for (int i = 0; i < str.length(); i++) { //проходит по каждому символу в строке
            if (str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public static String getInitials(String name) {
        StringBuilder initials = new StringBuilder(); //разделяется на слова с помощью метода ..., пробел как разделитель
        for (String word : name.split(" ")) { //по каждому слову
            initials.append(word.charAt(0)); // берется первый символ и добавляется в инищиал
        }
        return initials.toString();
    }
    public static int differenceEvenOdd(int[] arr) {
        int evenSum = 0;
        int oddSum = 0;
        for (int num : arr) { // проходит по каждому числу в массиве
            if (num % 2 == 0) { // является ли числа четным
                evenSum += num; //если да
            } else {
                oddSum += num; // если нет
            }
        }
        return Math.abs(evenSum - oddSum); //возвращается разница с помощью функции ...
    }
    public static boolean equalToAvg(int[] arr) {
        int sum = 0;
        for (int num : arr) { //вычисляем сумму ысех чисел в массиве
            sum += num;
        }
        double avg = (double) sum / arr.length; // вычисляем среднее значение путем деления суммы на длину м.
        for (int num : arr) { //проходит по каждому числу в массиве
            if (num == avg) { // число сравнивается со средним значением  ...
                return true;
            }
        }
        return false;
    }
    public static int[] indexMult(int[] arr) {
        int[] result = new int[arr.length]; // создается новый массив с тем же размером
        for (int i = 0; i < arr.length; i++) { //проходит по каждому элементу в массиве
            result[i] *= i;//индекс
        }
        return result;
    }
    public static String reverse(String str) {
        char[] chars = str.toCharArray(); // конвентируется в массив символов с помощью методов
        String finih = ""; //создается пустая строка, будет содержать обратную строку
        for (int i = chars.length - 1; i >= 0; i--) { //проходит по каждому символу в массиве в обратном порядке
            finih = finih + chars[i]; //на каждой интерации символ добовляется в начало строки
        }
        return finih;
    }
    public static int Tribonacci(int n) {
        if (n == 0 || n == 1) { //проверяем базовый случай
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int[] sequence = new int[n]; //заздаем массив, хранится последовательность ч
            sequence[0] = 0;
            sequence[1] = 0;
            sequence[2] = 1;
            for (int i = 3; i < n; i++) { // проходит от 1 до n-1 и вычисляет каждое последующее число как сумму 3 пред. ч.
                sequence[i] = sequence[i - 1] + sequence[i - 2] + sequence[i - 3];
            }
            return sequence[n-1];
        }
    }
    public static String pseudoHash(int length) {
        String hash = ""; // создается пустая строка
        String characters = "abcdef0123456789"; //строка с набором символов
        Random random = new Random();//переменная //ь для генерации случайных чисел
        for (int i = 0; i < length; i++) { //проходит length раз и добовляет случайный символ в строку
            hash += characters.charAt(random.nextInt(characters.length()));
        }
        return hash;
    }
    public static String botHelper(String str) {
        if (str.toLowerCase().contains("help")) { //если стр содержет хелп
            return "Calling for a staff member";
        } else {
            return "Keep waiting";
        }
    }
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) { //если длины не равны то функция возвращает фолз
            return false;
        }
        char[] arr1 = str1.toUpperCase().toCharArray(); // преобразуется в массив с помощью метода
        char[] arr2 = str2.toUpperCase().toCharArray();
        Arrays.sort(arr1); //сортируется по возрастанию
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2); //для сравнения
    }
}