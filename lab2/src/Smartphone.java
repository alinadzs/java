import java.util.ArrayList;
import java.util.Arrays;

public class Smartphone extends Gadget{

    private String screenType;
    private boolean wirelessCharge;
    private int cameraCount;

    Smartphone() {
        wirelessCharge = false;
        cameraCount = 1;
    }
    Smartphone(String screenType, boolean wirelessCharge, int cameraCount) {
        this.screenType = screenType;
        this.wirelessCharge = wirelessCharge;
        if (cameraCount >= 1) {this.cameraCount = cameraCount;}
    }
    private String[] cameraModes() {
        if (cameraCount > 1) { return new String[] {"photo", "portrait", "slow motion", "timelapse"};}
        return new String[] {"phone"};
    }
    public void getAllInfo() {
        System.out.println("Name "+ getName());
        System.out.println("OS: " + getOs());
        System.out.println("Screen type: " + screenType);
        System.out.println("Wireless charge: " + (wirelessCharge? "yes": "no"));
        System.out.println("Camera modes" + Arrays.toString(cameraModes()));
    }
}
