public abstract class Gadget {
    private String name;
    private String os;
    public static int count;

    Gadget() {
        count++;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setOs(String os) {
        this.os = os;
    }
    public String getName() {
        return name;
    }
    public String getOs(){
        return os;
    }
    public abstract void getAllInfo();
}
