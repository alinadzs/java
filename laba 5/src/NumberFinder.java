import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void main(String[] args){
        String text = "Tese was founded in 1920 , but it wwaq 12.02.03.4.4.5.6.7 ddsa 12.112";
        //numbers
        findNumber(text);

        //password
        String password1 = "Alina8dzs";
        String password2 = "alinadzs";
        checkPassword(password1);
        checkPassword(password2);

        //IP
        String ip1 = "123.224.143.150";
        String ip2 = "123.266.111.111";
        ipAdress(ip1);
        ipAdress(ip2);

        // find words
        String lines = "Its check fun on char imp.";
        char findChar = 'i';
        findWords(lines,findChar);

        // replace links
        String link = "Пример текста с ссылкой http://www.example.com и еще одной www.google.com";
        replaceLinks(link);


    }
/* Метод "findNumber" принимает текстовую строку "text" и ищет в ней все числа, включая десятичные.
В начале метода создается объект класса "Pattern", который представляет собой шаблон для поиска чисел.
Паттерн указывает на то, что искомые числа могут быть как положительными, так и отрицательными и могут содержать десятичную часть.
Затем создается объект класса "Matcher", который будет производить поиск чисел по заданному шаблону в заданной строке.
После этого, с помощью цикла "while", происходит поиск чисел в тексте и выводится каждое найденное число на консоль.
 */
    public static void findNumber(String text){
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)*");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.println("Найдено: " + matcher.group());
        }
    }
/*Метод "checkPassword" принимает строку "password" и проверяет, соответствует ли она требованиям к паролю.
В начале метода создается объект класса "Pattern", который представляет собой шаблон для проверки пароля.
Паттерн указывает на следующие требования:
- Пароль должен содержать как минимум одну заглавную букву (латинский алфавит).
- Пароль должен содержать как минимум одну цифру.
- Пароль должен состоять из строчных и заглавных букв латинского алфавита, а также цифр.
- Длина пароля должна быть от 8 до 16 символов.
Затем создается объект класса "Matcher", который будет производить проверку пароля по заданному шаблону.
Если пароль соответствует требованиям, выводится сообщение "Password good", иначе выводится сообщение "Password not good".
 */
    public static void checkPassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}");
        Matcher matcher = pattern.matcher(password);

        if(matcher.matches()){
            System.out.println("Password good");
        }
        else{
            System.out.println("Password not good");
        }

    }
/*Метод "ipAdress" принимает строку "ip" и проверяет, является ли она допустимым IP-адресом.
В начале метода создается объект класса "Pattern", который представляет собой шаблон для проверки IP-адреса.
Паттерн указывает на следующие требования:
- Каждая часть IP-адреса должна быть в диапазоне от 0 до 255.
Затем создается объект класса "Matcher", который будет производить проверку IP-адреса по заданному шаблону.
Если IP-адрес соответствует требованиям, выводится сообщение "IP correct", иначе выводится сообщение "IP not correct".
 */
    public static void ipAdress(String ip){
        Pattern pattern = Pattern.compile("(([0-1][0-9][0-9]|2([0-4][0-9]|5[0-4]))\\.){3}(([0-1][0-9][0-9]|2([0-4][0-9]|5[0-4])))");
        Matcher matcher = pattern.matcher(ip);

        if(matcher.matches()){
            System.out.println("IP correct");
        }
        else{
            System.out.println("IP not correct");
            //throw ?
        }
    }
/*Метод "findWords" принимает строку "str" и символ "ch" и ищет все слова из строки, которые начинаются с заданного символа.
Сначала создается регулярное выражение (шаблон), которое указывает на слова, начинающиеся с заданного символа.
Затем создается объект класса "Pattern", который представляет собой шаблон для поиска таких слов.
После этого создается объект класса "Matcher", который будет производить поиск таких слов по заданному шаблону в заданной строке.
С помощью цикла "while" происходит поиск таких слов в строке и выводится каждое найденное слово на консоль.
 */
    public static void findWords(String str, char ch){
        String regex = "\\b" + ch + "\\w*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str.toLowerCase());

        System.out.println("Слова начинающиеся с " + ch + ":");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
/* Метод "replaceLinks" принимает строку "text" и заменяет в ней все ссылки на HTML-ссылки.
Сначала создается регулярное выражение (шаблон), которое указывает на ссылки в формате "http://" или "www.".
Затем вызывается метод "replaceAll", который заменяет все найденные ссылки на HTML-ссылки, используя шаблон и заданный текст.
Замененный текст выводится на консоль, а также возвращается в качестве результата метода.
 */
    public static String replaceLinks(String text){
        String regex = "(http[s]?://\\S+|www\\.\\S+)";

        text = text.replaceAll(regex,"<a href=\"$0\">$0</a>");

        System.out.println(text);
        return text;
    }
}
