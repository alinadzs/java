//код создает специализированное исключение, которое, когда бросается и перехватывается,
//записывает сообщение об ошибке в файл журнала
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//создается новый класс `CustomAgeException`, который является расширением (наследником) класса `Exception`
//Это означает, что `CustomAgeException` является особым типом исключительной ситуации, которую можно использовать там, где это целесообразно в вашей программе
public class CustomAgeException extends Exception {
    CustomAgeException(String message) {//есть конструктор, который принимает строковое сообщение (`String message`)
        super(message);//В конструкторе сообщение передается в конструктор базового класса (`super(message)`)
        loggError(message);//вызывается метод `loggError`
    }
    public static void loggError(String error) {//Метод `loggError` записывает сообщение об ошибке
        // в файл с именем "errors.txt", который располагается в текущем каталоге исполнения программы
        File log = new File("errors.txt");
//создает объект `File`, представляющий указанный файл
//Затем он открывает файл с использованием `FileWriter`
//Если файл уже существует, он будет открываться в режиме "дописать в конец" (параметр `true` в `new FileWriter`).
        try {
            FileWriter writer = new FileWriter(log, true);
            writer.write(error + "\n");//Запись сообщения об ошибке (`error + "\n"`) происходит в файл
//Независимо от того, случится ли здесь исключение или нет, поток записи в файл (`writer`) закрывается посредством вызова `writer.close()`
            writer.close();
//Если при этом произойдет исключение `IOException`, оно будет перехвачено и заменено на непроверяемое исключение
//`RuntimeException`, которое получит информацию о первоначальном исключении (причина).
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}