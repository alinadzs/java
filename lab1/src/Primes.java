//выводит простые числа меньше 100
public class Primes {

    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) { //выполняется для чисел от 2 до 100
//для каждого числа вызывается метод "isPrime", который проверяет является ли число простым или нет
            System.out.println(i + " " + isPrime(i));


        }
    }
    //является ли число простым
    public static boolean isPrime(int n){ // проверяет является ли число "n" простым
        for (int i = 2; i < n; i++) { //цикл перебирает числа от 2 до "n-1"
            if (n % i == 0) { //делится ли "n" на них без остатка
                return false; //если делится
            }
        }
        return true; //если не делится
    }
}
