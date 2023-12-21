import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println(sameLetterPattern("abab", "cdcd")); // 1
        System.out.println(spiderVsFly("H4", "G3")); // 2
        System.out.println(digitsCount(1289396387328L)); // 3
        System.out.println(totalPoints(new String[] { "trance", "recant" }, "recant")); // 4
        System.out.println(sumsUp(new int[] { 1, 6, 5, 4, 8, 2, 3, 7 })); // 5
        System.out.println(takeDownAverage(new String[] { "95%", "83%", "90%", "87%", "88%", "93%" })); // 6
        System.out.println(caesarCipher("decode", "almost last task!", 4)); // 7
        System.out.println(setSetup(7, 3)); // 8
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra")); // 9
        System.out.println(isNew(123));
    }

   /* public static String printTwoDimensialArray(int[][] arr) {
        String res = "[";
        for (int[] i : arr) {
            res += "[";
            for (int el : i) {
                res += el + ", ";
            }
            res = res.substring(0, res.length() - 2);
            res += "], ";
        }
        res = res.substring(0, res.length() - 2);
        res += "]";
        return res;
    }

    */
/* Метод sameLetterPattern(String s, String t) определяет, являются ли две строки s и t строками, в которых
повторяется одна и та же буква в одном и том же порядке. Он использует хэш-карты для отслеживания соответствия
 символов в обеих строках.
 */
    public static boolean sameLetterPattern(String s, String t)
    {
        if(s.length() != t.length()) { //если длина строки s не равна длине строки t, то возвращает false.
            return false;
        }
//HashMap - smap и tmap, которые будут хранить символы строки s и t в качестве ключей и их индексы в качестве значений.
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
      //если значение с символом из строки s в smap не равно значению с символом из строки t в tmap, то метод возвращает false.
            if(smap.get(s.charAt(i)) != tmap.get(t.charAt(i))) return false;
            smap.put(s.charAt(i), i);//если совпадают
            tmap.put(t.charAt(i), i);
        }
        return true;
    } // 1

 /* Метод spiderVsFly(String spider, String fly) определяет кратчайший путь паука на паутине к мухе.
 Паук и муха представлены в виде строк с символами, представляющими радиальное расположение (от A до H) и
 радиальное кольцо. Метод использует циклы и условные операторы для определения пути паука.
  */
  public static String spiderVsFly(String spider, String fly) {
      int spiderRing = Integer.parseInt(String.valueOf(spider.charAt(1))); //для получения значения кольца
      char spiderRadial = spider.charAt(0);
      int flyRing = Integer.parseInt(String.valueOf(fly.charAt(1))); //для радиала каждого объекта
      char flyRadial = fly.charAt(0);

      StringBuilder path = new StringBuilder();//объект StringBuilder под названием path, который будет содержать путь паука до мухи.
      boolean clockwise = true;
/* паук двигается по кольцам в зависимости от того, находится ли паук на меньшем или большем кольце по сравнению с мухой.
При каждом шаге позиция паука записывается в path, а затем паук перемещается на следующее кольцо.
*/
      while (spiderRing != flyRing) {
          if (spiderRing < flyRing) {
              path.append(spiderRadial);
              path.append(spiderRing);
              path.append("-");
              if (clockwise) {
                  spiderRing++;
              } else {
                  spiderRing--;
              }
          } else {
              path.append(spiderRadial);
              path.append(spiderRing);
              path.append("-");
              if (clockwise) {
                  spiderRing--;
              } else {
                  spiderRing++;
              }
          }
      }

      List<Character> radialList = new ArrayList<>();//создается список
      radialList.add(spiderRadial); //добавляется радиал паука
//в зависимости от направления движения паука (по или против часовой стрелки) в список добавляются все остальные радиалы, через которые паук должен пройти.
      if (clockwise) {
          for (char c = (char) (spiderRadial + 1); c <= 'H'; c++) {
              radialList.add(c);
          }
          for (char c = 'A'; c < flyRadial; c++) {
              radialList.add(c);
          }
      } else {
          for (char c = (char) (spiderRadial - 1); c >= 'A'; c--) {
              radialList.add(c);
          }
          for (char c = 'H'; c > flyRadial; c--) {
              radialList.add(c);
          }
      }

      for (char radial : radialList) {
          path.append(radial);
          path.append(flyRing);
          path.append("-");
      }

      path.append(fly);//добовляется в path

      return path.toString();
  }//2

 /* Метод digitsCount(long number) рекурсивно определяет количество цифр в заданном числе. Он использует деление
 числа на 10 до тех пор, пока число не станет равным 0, и считает количество рекурсивных вызовов.
  */
    public static int digitsCount(long number) {
        if (number == 0)
            return 0;
        return 1 + digitsCount(number / 10);
    } // 3

/* Метод totalPoints(String[] arr, String word) вычисляет общее количество очков, которые можно набрать из
списка слов arr с использованием заданного слова word. Каждая буква в слове arr оценивается определенным
количеством очков, которое зависит от длины слова и уникальности букв в слове.
 */
    public static int totalPoints(String[] arr, String word) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int score = arr[i].length() == 6 ? 54 : arr[i].length() - 2;
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].indexOf(arr[i].charAt(j)) == -1) {
                    break;
                }
            }
            res += score;
        }
        return res;
    } // 4
/* В методе sumsUp происходит поиск пар чисел в массиве arr, которые в сумме дают 8. Если такая пара найдена,
она добавляется в список res. Для этого используется Map<Integer, Integer> для хранения уже просмотренных чисел,
и проверяется каждое число массива arr, если сумма числа и ключа из Map равна 8, то пара добавляется в список.
Числа в паре добавляются в порядке возрастания.
 */
    public static ArrayList<ArrayList<Integer>> sumsUp(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int indexRes = 0;//использоваться для отслеживания индекса в res.
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();//который будет использоваться для хранения чисел и их количества
        for (int i = 0; i < arr.length; i++) {// пробегает по каждому элементу массива arr
            boolean b = true;//для проверки
            for (Integer key : map.keySet()) {
                if (key + arr[i] == 8) {//сумма ключа и текущего элемента arr[i] равна 8
                    ArrayList<Integer> cl = new ArrayList<Integer>();//создается новый ArrayList с именем cl
                    cl.add(0, Math.min(key, arr[i]));//минимальное значение между ключом и arr[i]
                    cl.add(1, Math.max(key, arr[i]));//максимальное значение
                    res.add(indexRes, cl);//ArrayList добавляется в res по индексу indexRes
                    indexRes++;//индекс увеличивается на 1
                    map.remove(key, 1);//map удаляется ключ со значением 1
                    b = false;//переменная b устанавливается в false и происходит выход из вложенного цикла
                    break;
                }
            }
            if (b)//b остается true, то в map добавляется новый ключ arr[i] со значением 1
                map.put(arr[i], 1);
        }
        return res;
    } // 5

/* В методе takeDownAverage вычисляется среднее значение чисел, которые представлены в виде строк с символом процента.
Затем вычисляется разность между средним значением и 5, умноженная на количество чисел в массиве.
Полученное значение округляется и приводится к строке с символом процента.
 */
    public static String takeDownAverage(String[] arr) {
        if (arr.length == 0)//проверяем длину массива
            return "0%";
        double sum = 0;//будет суммироватся общее количество процентов из массива arr
        for (String str : arr) {
            int number = Integer.parseInt(str.split("%")[0]);//каждый элемент разделяется с помощью метода split("%") на число и знак "%" и преобразуем в тип int
            sum += number;//добавляем
        }
        double avg = sum / arr.length;//вычисляется среднее значение avg путем деления суммы sum на длину массива arr
        double res = (arr.length + 1) * (avg - 5) - sum;//вычисляется оценка, которую необходимо получитья в следующий раз
        return Integer.toString((int) Math.round(res)) + "%";//возвращается строка, состоящая из округленной до целого числа оценки и символа "%"
    } // 6

/* В методе caesarCipher происходит шифрование или дешифрование строки str по алгоритму Цезаря с использованием
заданного сдвига shift. В зависимости от значения параметра mode определяется направление шифрования или дешифрования.
 */
    public static String caesarCipher(String mode, String str, int shift) {
        if (mode == "decode")
            shift *= -1;
        str = str.toUpperCase();
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            int el = str.codePointAt(i);
            int number = el + shift;
            if (el >= 65 && el <= 90) {
                if (number < 65) {
                    number = 91 - (65 - number);
                } else if (number > 90) {
                    number = 64 + (number - 90);
                }
                res += Character.toString((char) number);
            } else {
                res += Character.toString((char) el);
            }
        }

        return res;
    } // 7

/* В методе factorial рекурсивно вычисляется факториал числа n.
В методе setSetup вычисляется количество возможных комбинаций из n элементов по k элементов, используя факториальную
функцию из предыдущего метода.
 */
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int setSetup(int n, int k) {
        if (n < k) {
            return 0;
        }
        return factorial(n) / factorial(n - k);
    } // 8

/* В статическом блоке кода инициализируется Map cityOffsets, где ключами являются названия городов,
а значениями - смещения относительно времени в Лондоне. Затем в методе timeDifference происходит вычисление
разницы во времени между городами cityA и cityB на основе переданной временной метки timestamp.
 */
    private static final Map<String, Duration> cityOffsets = new HashMap<>();//создается статический словарь cityOffsets

    static {
        cityOffsets.put("Los Angeles", Duration.ofHours(-8));
        cityOffsets.put("New York", Duration.ofHours(-5));
        cityOffsets.put("Caracas", Duration.ofHours(-4).plusMinutes(-30));
        cityOffsets.put("Buenos Aires", Duration.ofHours(-3));
        cityOffsets.put("London", Duration.ofHours(0));
        cityOffsets.put("Rome", Duration.ofHours(1));
        cityOffsets.put("Moscow", Duration.ofHours(3));
        cityOffsets.put("Tehran", Duration.ofHours(3).plusMinutes(30));
        cityOffsets.put("New Delhi", Duration.ofHours(5).plusMinutes(30));
        cityOffsets.put("Beijing", Duration.ofHours(8));
        cityOffsets.put("Canberra", Duration.ofHours(10));
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.US);//объект с указанным шаблоном
//Из строки timestamp методом parse собирает объект dateTimeA класса LocalDateTime с использованием созданного ранее formatter.
        LocalDateTime dateTimeA = LocalDateTime.parse(timestamp, formatter);

        Duration offsetA = cityOffsets.getOrDefault(cityA, Duration.ZERO);//получает значения из словаря, если нет то присваивает Duration.ZERO
        LocalDateTime dateTimeB = dateTimeA.plus(offsetA);//добовляется смещение и получается новый объект

        Duration offsetB = cityOffsets.getOrDefault(cityB, Duration.ZERO);
        dateTimeB = dateTimeB.plus(offsetB);

        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");//новый объект
        return dateTimeB.format(newFormatter);//форматируется в строку и выводится эта строка
    } //9

/* В методе isNew проверяется, является ли число num новым. Число считается новым, если каждая следующая цифра,
начиная с первой, больше или равна предыдущей, за исключением нулевых цифр.
 */
    public static boolean isNew(int num) {
        String str = String.valueOf(num);//преобразуется в строку
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) != '0' && str.charAt(i) < str.charAt(0)) {//если текущий символ не равен нулю и меньше первого символа строки
                return false;//то возвращается значение false
            }
        }
        return true;
    } // 10
}