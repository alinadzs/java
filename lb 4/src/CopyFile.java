import java.io.*;
import java.util.Scanner;
//коде программа пытается скопировать содержимое из одного файла `file1.txt` в другой файл `newFile.txt`.
public class CopyFile {
    public static void main(String[] args) {
//Открывает файл `file1.txt` для чтения с помощью объекта класса `Scanner`.
        try {
            File currentFile = new File("file1.txt");
            File file = new File("newFile.txt");
            Scanner scanner = new Scanner(currentFile);
            scanner.close();
//создает или открывает файл `newFile.txt` с помощью объекта `FileWriter`.
            try {
                FileWriter writer = new FileWriter(file);
                //writer.close();
//С помощью `Scanner` в цикле "пока есть следующая строка" (`hasNextLine`) читает строку из `file1.txt`
//и записывает ее в `newFile.txt`, затем добавляет символ новой строки "`\n`".
                while (scanner.hasNextLine()) {
                    writer.write(scanner.nextLine());
                    writer.write("\n");
                }
                writer.close();
                //scanner.close();
//после создания объекта сканера для чтения файла `file1.txt`, сканер немедленно закрывается с помощью `scanner.close();`
//прежде чем какая-либо чтение была выполнена. Это приводит к тому что когда код пытается прочитать из файла с помощью того же сканера в цикле,
//будет выброшено исключение `IllegalStateException` с сообщением "поток закрыт", так как поток ввода, связанный со сканером был закрыт.
            } catch (IOException e) {
                System.err.println("ошибка при записи файла");
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        catch (IllegalStateException e) {
            System.err.println("поток закрыт");
        }
    }
}
//Код корректно обрабатывает исключения - в частности, `IOException` при проблемах с чтением или записью файлов,
//и `IllegalStateException` в случае попытки использовать закрытый поток.