public class Laptop extends Gadget{
    private float displaySize;
    private boolean fingerPrint;
    private String materialCase;

    public void setInfo(float displaySize) {
        this.displaySize = displaySize;
    }
    public void setInfo(float displaySize, boolean fingerPrint, String materialCase) {
        this.displaySize = displaySize;
        this.fingerPrint = fingerPrint;
        this.materialCase = materialCase;
    }
    public void getAllInfo() {
        System.out.println("Name "+ getName());
        System.out.println("OS: " + getOs());
        System.out.println("Display size: " + displaySize + " inch");
        System.out.println("Finger print: " + (fingerPrint? "yes": "no"));
        System.out.println("Material case: " + materialCase);
    }
}
