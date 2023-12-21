//В данном коде создан класс "FitnesBracelet", который является подклассом класса "Watch"
public class FitnesBracelet extends Watch{
//определение дополнительных полей
    private int trainingCount;
    private boolean waterProof;
    private boolean gps;

//Метод "getAllInfo()" переопределен из класса "Watch" и расширяет его функциональность
    @Override//это переопределение, подкласс может реализовать метод родительского класса на основе его требования.
    public void getAllInfo() {
        //вывод информации о всех полях объекта
        super.getAllInfo();
        System.out.println("Training count: " + trainingCount);
        System.out.println("Waterproof: " + (waterProof? "yes": "no"));
        System.out.println("GPS: " + (gps? "yes": "no"));
        System.out.println("RAM: " + getRam());
    }
//Метод "StartTrain()" принимает параметр "trainingMode" и возвращает строку, соответствующую выбранному режиму тренировки
    public String StartTrain(int trainingMode) {
        return switch (trainingMode) { //Используется оператор switch для ветвления в зависимости от значения "trainingMode"
            case 1 -> "running";
            case 2 -> "swimming";
            case 3 -> "crossfit";
            default -> "none";
        };
    }

}
