import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println("_______________________");
        System.out.println(Arrays.toString(generateBrackets(1)));
        System.out.println(Arrays.toString(generateBrackets(2)));
        System.out.println(Arrays.toString(generateBrackets(3)));
        System.out.println("________________________");
        System.out.println(Arrays.toString(binarySystem(3)));
        System.out.println(Arrays.toString(binarySystem(4)));
        System.out.println("_________________________");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println(alphabeticRow("klmabzyzyxw"));
        System.out.println("_________________________");
        System.out.println(alphCount("aaabbcdd"));
        System.out.println(alphCount("vvvvaajaaaaa"));
        System.out.println("_________________________");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println(convertToNum("nine hundred ninety nine"));
        System.out.println(convertToNum("nine hundred nine"));
        System.out.println("_________________________");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println(uniqueSubstring("77897891238"));
        System.out.println("_________________________");
        System.out.println(shortestWay(new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
        System.out.println(shortestWay(new int[][]{{2, 7, 3}, {1, 4, 8}, {4, 5, 9}}));
        System.out.println("_________________________");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println("_________________________");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));

    }

    /*
    1.  Функция nonRepeatable принимает строку и удаляет из неё повторяющиеся символы. Она рекурсивно проверяет
     каждый символ и добавляет его в результирующую строку только в случае, если такого символа в ней ещё нет
    */
    public static String nonRepeatable(String s) {
        if (!s.isEmpty()) {
            String sim = Character.toString(s.charAt(0));
            return sim + nonRepeatable(s.replace(sim, ""));
        } else return "";
    } //возвращает символ, который встречается 1 раз

/*
2. Функция generateBrackets генерирует все возможные правильные комбинации пар скобок для заданного числа n
 использует рекурсивный алгоритм backtrack для построения комбинаций. Каждый раз функция может добавить либо
 открывающую, либо закрывающую скобку в текущую комбинацию. В итоге, функция возвращает массив строк, содержащих
 все комбинации скобок
*/

    public static String[] generateBrackets(int n) {
        List<String> combinations = new ArrayList<>();
        backtrack("", 0, 0, n, combinations);
        String[] s = new String[combinations.size()];
        int i = 0;
        for (String el : combinations) {
            s[i] = el;
            i++;
        }
        return s;
    }

    public static void backtrack(String com, int open, int close, int n, List<String> combinations) {
        if (com.length() == n * 2) {
            combinations.add(com);
        } else {
            if (open < n) {
                backtrack(com + "(", open + 1, close, n, combinations);
            }
            if (close < open) {
                backtrack(com + ")", open, close + 1, n, combinations);
            }
        }
    }

    /*
    3. Функция binarySystem генерирует все возможные бинарные комбинации длины n, в которых не может быть соседствующих
    нулей
    использует рекурсивный алгоритм backtrack для построения комбинаций. Каждый раз функция может добавить либо 0,
    либо 1 в текущую комбинацию, но проверяет, чтобы не было соседних нулей. В итоге, функция возвращает массив строк,
    содержащих все комбинации
    */
    public static String[] binarySystem(int n) {
        List<String> combinations = new ArrayList<>();
        backtrack("", n, combinations);
        String[] s = new String[combinations.size()];
        int i = 0;
        for (String el : combinations) {
            s[i] = el;
            i++;
        }
        return s;
    }

    public static void backtrack(String combination, int n, List<String> combinations) {
        if (combination.length() == n) {
            combinations.add(combination);
        } else {
// Проверяем, можно ли добавить 0 к текущей комбинации
            if (!combination.endsWith("0")) {
                backtrack(combination + "0", n, combinations);
            }
// Всегда можно добавить 1
            backtrack(combination + "1", n, combinations);
        }
    }

    /*
    4. Функция alphabeticRow принимает строку и возвращает длину самого длинного последовательного ряда букв в
    алфавитном порядке
    Функция проходит по каждой букве строки и сравнивает её с предыдущей. Если текущая буква следует после предыдущей в
    алфавитном порядке, то увеличивает счетчик. Если не следует, то обновляет счетчик и продолжает проверку со
    следующей буквой. В итоге, функция возвращает длину самого длинного ряда
    Последовательный ряд – это список соседних элементов, идущих подряд в алфавитном порядке,
    который может быть как увеличивающимся, так и уменьшающимся.
    */
    public static String alphabeticRow(String str) {
        String longestStr = "";
        StringBuilder currentStr = new StringBuilder();
        currentStr.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1) + 1 || str.charAt(i) == str.charAt(i - 1) - 1) {
                currentStr.append(str.charAt(i));
            } else {
                if (longestStr.length() < currentStr.length()) {
                    longestStr = currentStr.toString();
                }
                currentStr = new StringBuilder();
                currentStr.append(str.charAt(i));
            }
        }
        if (longestStr.length() < currentStr.length()) {
            longestStr = currentStr.toString();
        }
        return longestStr;
    }

    /*
    5.  Функция alphCount принимает строку и подсчитывает количество идущих подряд символов, заменяя соответствующим
    числом повторяющиеся символы
    использует Map для подсчета повторений каждого символа в строке. Затем она сортирует значения (`values`) в порядке
    возрастания и построение строки res, в которой символы и их повторения чередуются. В итоге, функция возвращает
    отсортированную строку
    */
    public static String alphCount(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : string.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        StringBuilder res = new StringBuilder();
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        while (!values.isEmpty() && !map.isEmpty()) {
            for (Character key : map.keySet()) {
                if (map.get(key).equals(values.get(0))) {
                    res.append(key);
                    res.append(values.get(0));
                    map.remove(key);
                    values.remove(0);
                    break;
                }
            }
        }
        return res.toString();
    }

    /*
    6.  Функция convertToNum принимает положительное целое число в строковом формате и возвращает его целочисленное
    представление.  использует Map, где ключом является строковое представление числа, а значением - его целочисленное
    представление. Функция разбивает строку числа на отдельные слова и с помощью Map конвертирует каждое слово в
    числовое значение. Затем функция складывает числа и возвращает итоговую сумму
    */
    public static int convertToNum(String numberString) {
        Map<String, Integer> numberMap = new HashMap<>();
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);
        numberMap.put("ten", 10);
        numberMap.put("eleven", 11);
        numberMap.put("twelve", 12);
        numberMap.put("thirteen", 13);
        numberMap.put("fourteen", 14);
        numberMap.put("fifteen", 15);
        numberMap.put("sixteen", 16);
        numberMap.put("seventeen", 17);
        numberMap.put("eighteen", 18);
        numberMap.put("nineteen", 19);
        numberMap.put("twenty", 20);
        numberMap.put("thirty", 30);
        numberMap.put("forty", 40);
        numberMap.put("fifty", 50);
        numberMap.put("sixty", 60);
        numberMap.put("seventy", 70);
        numberMap.put("eighty", 80);
        numberMap.put("ninety", 90);
        numberMap.put("hundred", 100);

        String[] words = numberString.split(" ");
        int current = 0;

        for (String word : words) {
            int value = numberMap.get(word);

            if (value == 100) {
                current = current * value;
            } else {
                current += value;
            }
        }

        return current;
    }

    /*
    7. Функция uniqueSubstring принимает строку цифр и выполняет поиск подстроки максимальной длины с уникальными
    символами. использует Set для хранения уникальных символов и два указателя startIndex и i для отслеживания текущей
    подстроки. Функция проходит по строке посимвольно и при обнаружении повторяющегося символа, сдвигает startIndex и
    удаляет предыдущие символы из Set. Затем функция обновляет самую длинную найденную подстроку и возвращает её
     */
    public static String uniqueSubstring(String str) {
        String longestSubstring = "";
        Set<Character> uniqueSet = new HashSet<>();
        int startIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            while (uniqueSet.contains(currentChar)) {
                uniqueSet.remove(str.charAt(startIndex));
                startIndex++;
            }

            uniqueSet.add(currentChar);

            if (i - startIndex + 1 > longestSubstring.length()) {
                longestSubstring = str.substring(startIndex, i + 1);
            }
        }

        return longestSubstring;
    }

    /*
    8. Функция shortestWay принимает двумерный массив matrix и выполняет поиск наименьшего матричного пути.
    использует динамическое программирование и создает массив dp размера n x n, где dp[i][j] представляет минимальную
    сумму чисел до позиции (i, j). Затем функция проходит по матрице и на каждом шаге выбирает минимальную сумму из
    двух возможных предыдущих путей: сверху и слева от текущей позиции. В итоге, функция возвращает минимальную сумму
    на пути от верхнего левого угла до нижнего правого угла матрицы.

    */
    public static int shortestWay(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

// Инициализация первой строки и первого столбца
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }

// Нахождение наименьшего пути для остальных ячеек
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n - 1][n - 1];
    }

/*
9.  Функция numericOrder принимает строку, содержащую числа внутри слов. Эти числа представляют расположение слова для
новой строящейся строки. Функция переставляет слова в порядке, указанном числами, и возвращает результирующую строку.
*/

    public static String numericOrder(String s) {
        String[] words = s.split(" ");
        StringBuilder fin = new StringBuilder();
        for (int i = 1; i <= words.length; i++) {
            for (String subStr : words) {
                if (subStr.contains(Integer.toString(i))) {
                    subStr = subStr.replace(Integer.toString(i), "");
                    fin.append(subStr);
                }
            }
            fin.append(" ");
        }
        return fin.toString();
    }

/*
10. Функция switchNums принимает два числа и делает второе число максимально возможным за счет замены своих элементов
элементами первого числа. Функция берет цифры из обоих чисел и выбирает максимальные цифры для формирования конечного
числа, при условии, что каждую цифру можно использовать только один раз. Результатом функции является полученное
максимально возможное число.
*/

    public static int switchNums(int a, int b) {
        List<Integer> numsA = new ArrayList<>();
        List<Integer> numsB = new ArrayList<>();

        while (a > 0) {
            numsA.add(a % 10);
            a = a / 10;
        }
        while (b > 0) {
            numsB.add(b % 10);
            b = b / 10;
        }

        int fin = 0;

        for (int i = numsB.size() - 1; i >= 0; i--) {
            int B = numsB.get(i);
            int ind = 0;
            if (!numsA.isEmpty()) {
                for (int j = 0; j < numsA.size(); j++) {
                    if (numsA.get(j) > B) {
                        B = numsA.get(j);
                        ind = j;
                    }
                }
                numsA.remove(ind);
            }
            fin = fin * 10 + B;
        }
        return fin;
    }
}
