public class Main {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone();
        s1.getAllInfo();
        Smartphone s2 = new Smartphone("IPS", true, 2);
        s2.getAllInfo();
        System.out.println("количество объектов " + Gadget.count);
        Laptop l1 = new Laptop();
        l1.setInfo(15.6f);
        Laptop l2 = new Laptop();
        l2.setInfo(13, true, "aluminium");
        System.out.println("количество объектов " + Gadget.count);
        Watch w1 = new Watch();
        FitnesBracelet f1 = new FitnesBracelet();
        f1.setRam((byte) 2);
        f1.getAllInfo();
        System.out.println("оличество объектов " + Gadget.count);
    }
}
