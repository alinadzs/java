public class FitnesBracelet extends Watch{

    private int trainingCount;
    private boolean waterProof;
    private boolean gps;

    @Override
    public void getAllInfo() {
        super.getAllInfo();
        System.out.println("Training count: " + trainingCount);
        System.out.println("Waterproof: " + (waterProof? "yes": "no"));
        System.out.println("GPS: " + (gps? "yes": "no"));
        System.out.println("RAM: " + getRam());
    }

    public String StartTrain(int trainingMode) {
        return switch (trainingMode) {
            case 1 -> "running";
            case 2 -> "swimming";
            case 3 -> "crossfit";
            default -> "none";
        };
    }

}
