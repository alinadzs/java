import java.util.ArrayList;
import java.util.Arrays;

//В данном коде определен класс "Smartphone", который наследуется от класса "Gadget"
public class Smartphone extends Gadget{

    private String screenType;//приватная переменная(тип экрана)
    private boolean wirelessCharge;//(наличие бесправодной зарядки),boolean-тип данных, пиременные которого принимают знаечение true/false
    private int cameraCount;//(количество камер) //int-хранит целые числа
//2 конструктора
    Smartphone() {
//Конструктор по умолчанию без параметров, который инициализирует переменные
        wirelessCharge = false;
        cameraCount = 1;
    }
//с параметрами "screenType", "wirelessCharge" и "cameraCount", который инициализирует все переменные значениями, переданными в аргументах конструктора
    Smartphone(String screenType, boolean wirelessCharge, int cameraCount) {
        this.screenType = screenType;
        this.wirelessCharge = wirelessCharge;
//если значение "cameraCount" больше или равно 1, то устанавливается значение переменной "cameraCount"
        if (cameraCount >= 1) {this.cameraCount = cameraCount;}
    }
    private String[] cameraModes() { //определен приватный метод, он возвращает массив строк
//Если значение переменной "cameraCount" больше 1, то возвращается массив строк с названиями режимов камеры ("photo", "portrait", "slow motion", "timelapse")
//Если значение "cameraCount" равно или меньше 1, то возвращается массив строк с единственным элементом "photo"
        if (cameraCount > 1) { return new String[] {"photo", "portrait", "slow motion", "timelapse"};}
        return new String[] {"photo"};
    }
    public void getAllInfo() { //публичный метод, выводиь информацию о смартфоне
        System.out.println("Name "+ getName());//название утройства
        System.out.println("OS: " + getOs());//операционная система
        System.out.println("Screen type: " + screenType);//тип экрана
        System.out.println("Wireless charge: " + (wirelessCharge? "yes": "no"));//наличие беспроводной зарядки
        System.out.println("Camera modes " + Arrays.toString(cameraModes()));//доступный режим камер
    }
}

