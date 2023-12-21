import java.util.*;

// Класс, представляющий книгу
class Book implements Comparable<Book> {
    String title; // название
    double price; // цена
    int soldCopies; // количество проданных копий

    // Конструктор для инициализации книги
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
        this.soldCopies = 0;
    }

    // Метод для увеличения количества проданных копий
    public void sellCopy() {
        this.soldCopies++;
    }

    // Методы для получения информации о книге
    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getSoldCopies() {
        return soldCopies;
    }

    // Метод для сравнения книги с другой книгой по названию
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    // Метод для получения информации о книге в виде строки
    @Override
    public String toString() {
        return title + " (Продано копий: " + soldCopies + ", Цена: " + price + ")";
    }
}

// Класс для управления продажами книг
public class BookSales {
    private TreeSet<Book> soldBooks; // Множество проданных книг

    // Конструктор для инициализации множества проданных книг
    public BookSales() {
        this.soldBooks = new TreeSet<>();
    }

    // Метод для добавления продажи книги
    public void addSale(Book book) {
        // Проверяем, есть ли уже такая книга в списке
        if (soldBooks.contains(book)) {
            soldBooks.forEach(b -> {
                // Если находим книгу в списке, увеличиваем количество проданных копий
                if (b.equals(book)) {
                    b.sellCopy();
                }
            });
        } else {
            // Если книги нет в списке, увеличиваем количество проданных копий и добавляем в список
            book.sellCopy();
            soldBooks.add(book);
        }
    }

    // Метод для вывода списка проданных книг
    public void printSoldBooks() {
        soldBooks.forEach(System.out::println);
    }

    // Метод для расчета общей суммы продаж
    public double totalSalesAmount() {
        // Используем стрим для вычисления суммы всех продаж
        return soldBooks.stream().mapToDouble(b -> b.getPrice() * b.getSoldCopies()).sum();
    }

    // Метод для поиска наиболее популярной книги
    public Book mostPopularBook() {
        // Используем метод max из класса Collections с компаратором, который сравнивает количество проданных копий
        return Collections.max(soldBooks, Comparator.comparingInt(Book::getSoldCopies));
    }

    public static void main(String[] args) {
        BookSales sales = new BookSales();

        // Создаем несколько книг
        Book book1 = new Book("Война и мир", 500);
        Book book2 = new Book("Гарри Поттер", 400);

        // Продаем книги
        sales.addSale(book1);
        sales.addSale(book2);
        sales.addSale(book1);

        // Выводим список проданных книг
        sales.printSoldBooks();

        // Выводим общую сумму продаж
        System.out.println("Общая сумма продаж: " + sales.totalSalesAmount());

        // Находим наиболее популярную книгу
        Book popularBook = sales.mostPopularBook();
        System.out.println("Наиболее популярная книга: " + popularBook.getTitle());
    }
}