//коде объявлен класс `AgeChecker`, который представляет сущность, имеющую возраст (`age`).
public class AgeChecker {
    private int age;//поле

//Метод `setAge` используется для установки значения возраста. Однако перед тем, как установить значение возраста,
//данный метод проверяет, попадает ли переданное значение в допустимый диапазон - от 0 до 120 лет
    public void setAge(int age) throws CustomAgeException {//метод
//Если поданное значение не попадает в данную границу (меньше 0 или больше или равно 120), то метод выбрасывает
//исключение `CustomAgeException` с сообщением "age is incorrect".
        if (age < 0 || age >= 120) {
            throw new CustomAgeException("age is incorrect");
        }
//если поданное значение попадает в допустимый диапазон, возраст устанавливается (`this.age = age`),
//и метод завершит выполнение без ошибок.
        this.age = age;
    }
}
//`CustomAgeException` является пользовательским определенным исключением, представляющим ошибки, связанные с неправильным возрастом.
//В методе используется ключевое слово `throws` для обозначения того, что метод может выбросить исключение типа `CustomAgeException`.
//Это означает, что любой код, который вызывает метод `setAge(int age)`, должен обрабатывать исключение типа
//`CustomAgeException` (либо напрямую через блок try-catch, либо же сам тоже объявлять, что выбрасывает это исключение).