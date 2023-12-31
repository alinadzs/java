//код выполняет задачу чтения 4 чисел с консоли и вычисления их среднего значения, обрабатывая возможные ошибки ввода
//и обращения к массиву
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);//Создается новый экземпляр класса Scanner, который принимает ввод с консоли

        int[] arr = new int[4];//новый массив целых чисел размером 4
        //Попытка прочитать следующее целое число из ввода пользователя и сохранить его в текущий элемент массива
        for (int i = 0; i < 4; i++) {
            try {
                arr[i] = in.nextInt();
            }
//Если подается неверный тип данных (не являющийся целым числом), то будет сгенерировано исключение
// InputMismatchException, которое обрабатывается, и выводится сообщение об ошибке
            catch (InputMismatchException exception) {
                System.err.println("указан неверный тип данных");
//счетчик цикла (i) декрементируется, чтобы повторить попытку чтения значения для текущего индекса массива.
// Строка in.nextLine(); служит для очищения буфера ввода от некорректного значения
                i--;
                in.nextLine();
            }
        }
        //инициализируется переменная sum с начальным значением 0
        int sum = 0;
            int index = 0;
//цикл while, который продолжается до тех пор, пока не будет сгенерировано исключение ArrayIndexOutOfBoundsException
// (то есть пока индекс не выйдет за границы массива)
        try {
            while (true) {
// К текущему значению sum прибавляется значение элемента массива arr с индексом index
                sum += arr[index];
                index++;//Индекс увеличивается на 1
            }
//Если индекс выходит за границы массива (счетчик превысил размер массива), генерируется исключение
//ArrayIndexOutOfBoundsException, которое также обрабатывается и выводится сообщение об ошибке
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println("вы вышли за границу массива");
        }
//независимо от того, было ли исключение или нет, блок finally выполняет операцию - выводит среднее арифметическое
// всех значений в массиве (sum / arr.length)
        finally {
            System.out.println(sum / arr.length);
        }
    }
}