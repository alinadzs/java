
//В данном коде происходит создание различных объектов классов Smartphone, Laptop, Watch и FitnesBracelet.
public class Main {
    public static void main(String[] args) {
//создается объект s1 класса Smartphone без параметров, затем вызывается метод getAllInfo() для вывода информации об объекте
        Smartphone s1 = new Smartphone();
        s1.getAllInfo();
//создается объект s2 класса Smartphone с заданными параметрами и также выводится информация с помощью метода getAllInfo()
        Smartphone s2 = new Smartphone("IPS", true, 2);
        s2.getAllInfo();
//выводится количество созданных объектов класса Gadget.
        System.out.println("количество объектов " + Gadget.count);
//создается объект l1 класса Laptop, устанавливается значение размера и выводится информация с помощью метода getAllInfo()
        Laptop l1 = new Laptop();
        l1.setInfo(15.6f);
// создается объект l2 класса Laptop, устанавливаются значения размера, наличия клавиатуры и материала корпуса, и также выводится информация
        Laptop l2 = new Laptop();
        l2.setInfo(13, true, "aluminium");
//выводится количество созданных объектов класса Gadget
        System.out.println("количество объектов " + Gadget.count);
//создаются объекты w1 класса Watch и f1 класса FitnesBracelet
        Watch w1 = new Watch();
        FitnesBracelet f1 = new FitnesBracelet();
// f1 устанавливается значение оперативной памяти и выводится информация с помощью метода getAllInfo()
        f1.setRam((byte) 2);
        f1.getAllInfo();
// выводится количество созданных объектов класса Gadget
        System.out.println("количество объектов " + Gadget.count);
    }
}