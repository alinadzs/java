public class Watch extends Gadget{
    private String caseShape;
    private boolean checkPulse;
    private byte ram;
    Watch() {
        caseShape = "circle";
        checkPulse = false;
    }
    public void setRam(byte ram) {
        if (ram >= 1) {this.ram = ram;}
    }
    public byte getRam() {
        return ram;
    }
    public String features() {
        if (ram >= 1 && ram <= 3) {
            return "notifications, receiving calls";
        }
        return "notification, receiving calls, music, games";
    }
    public void getAllInfo() {
        System.out.println("Name "+ getName());
        System.out.println("OS: " + getOs());
        System.out.println("Case shape: " + caseShape);
        System.out.println("heart rate measurement: " + (checkPulse? "yes": "no"));
        System.out.println("features " + features());
    }
}
