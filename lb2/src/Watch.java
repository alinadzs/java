// В данном коде определен класс Watch, который является наследником класса Gadget
public class Watch extends Gadget{
    private String caseShape;//приватная переменная (форма корпуса)
    private boolean checkPulse;//приватная(проверка пульса)
    private byte ram;//приватная(объем памяти) //byte-знаклвый 8-битный тип
//Конструктор Watch() инициализирует значения caseShape и checkPulse
    Watch() {
        caseShape = "circle";
        checkPulse = false;
    }
//Метод setRam(byte ram) устанавливает значение ram, если оно больше или равно 1
    public void setRam(byte ram) {
        if (ram >= 1) { this.ram = ram; }
    }
//Метод getRam() возвращает значение ram
    public byte getRam() {
        return ram;
    }
//Метод features() проверяет значение ram и возвращает строку с основными функциями часов в зависимости от объема оперативной памяти
    public String features() {
        if (ram >= 1 && ram <= 3) {
            return "notifications, receiving calls";
        }
        return "notifications, receiving calls, music, games";
    }
//Метод getAllInfo() выводит информацию о всех параметрах часов
    public void getAllInfo() {
        System.out.println("Name "+ getName());
        System.out.println("OS: " + getOs());
        System.out.println("Case shape: " + caseShape);
        System.out.println("heart rate measurement: " + (checkPulse? "yes": "no"));
        System.out.println("features " + features());
    }
}
