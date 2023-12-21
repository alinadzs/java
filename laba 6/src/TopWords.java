import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        // Путь к файлу, который ты хочешь использовать
        String filePath = "C:\\Users\\dzusk\\IdeaProjects\\laba 6\\words.txt";
        File file = new File(filePath);
        Scanner scanner = null;

        try {
            // Создаем объект Scanner для чтения файла
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Создаем HashMap для хранения слов и их количества в файле
        Map<String, Integer> wordCount = new HashMap<>();

        // Пока в сканере есть слова, выполняем цикл
        while (scanner != null && scanner.hasNext()) {
            // Получаем очередное слово из сканнера и удаляем все знаки препинания
            String word = scanner.next().replaceAll("\\W", "").toLowerCase();

            // Проверяем, есть ли уже такое слово в HashMap
            // Если есть, увеличиваем его количество на 1, иначе добавляем его со значением 1
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Закрываем сканнер
        if (scanner != null) {
            scanner.close();
        }

        // Создаем список из элементов HashMap
        List<Map.
                Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());

        // Сортируем список в порядке убывания значения (количество слова)
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // Выводим топ 10 наиболее часто встречающихся слов
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}