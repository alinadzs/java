//является ли введенная строка палидромом
public class Palindrome {
    public static void main(String[] args) {
        //создаем массив содержащих входных данных "s"
        String[] s = {"java", "Palindrome", "madam", "racecar", "apple", "kayak", "song", "noon"};
        for (int i = 0; i < s.length; i++){ //с помощью цикла перебираем все элемменты массива
            //проверяем каждое слово из массива и выводим результат на экран
            String stringForCheck = s[i];
//для каждого слова вызывается метод "Palindrome", который проверяет явл ли оно палидромом
            System.out.println (s[i] + ": " + isPalindrome(stringForCheck));

        }

    }
    // перевернутая строка
    public static String reverseString(String s) {
//s переворачивает заданнаю строку, путем прохода циклом по символам строки с конца
        String newString = "";
        for (int i = s.length() - 1; i >= 0; i--){
            char sym = s.charAt(i);
            newString += sym; //добовляет каждый символ в новую строку
        }
        return newString; //возвращает перевернутую строку
    }
    //проверяем, является ли палиндромом
    public static boolean isPalindrome (String s) { //вызывает метод "reverseString" для строки
        String reverse = reverseString(s); //получает перевернутую строки
        return reverse.equals(s); //сравнивает строки
    }
}
