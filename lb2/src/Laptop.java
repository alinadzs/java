//В данном коде объявлен класс Laptop, который является наследником класса Gadget
public class Laptop extends Gadget{
//приватные, хранят информацию о размере дисплея, наличии сканера отпечатков пальцев и материале корпуса
    private float displaySize;//float-определяет значение одинарной точности, занимают 32 бита
    private boolean fingerPrint;
    private String materialCase;
// Метод setInfo(float displaySize) принимает параметр displaySize и устанавливает его значение в соответствующую
// переменную displaySize
    public void setInfo(float displaySize) {
        this.displaySize = displaySize;
    }
//Метод setInfo(float displaySize, boolean fingerPrint, String materialCase) принимает три параметра displaySize,
//fingerPrint и materialCase и устанавливает их значения в соответствующие переменные displaySize, fingerPrint и materialCase
    public void setInfo(float displaySize, boolean fingerPrint, String materialCase) {
        this.displaySize = displaySize;
        this.fingerPrint = fingerPrint;
        this.materialCase = materialCase;
    }
//Метод getAllInfo() выводит на экран значения всех переменных объекта Laptop, а также название и операционную
// систему объекта Gadget, используя методы getName() и getOs() класса Gadget
    public void getAllInfo() {
        System.out.println("Name "+ getName());
        System.out.println("OS: " + getOs());
        System.out.println("Display size: " + displaySize + " inch");
        System.out.println("Finger print: " + (fingerPrint? "yes": "no"));
        System.out.println("Material case: " + materialCase);
    }
}
