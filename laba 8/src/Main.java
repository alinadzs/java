import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> inputData = List.of("text", "123123","" , " ", "date");
        java.nio.file.Files.write(java.nio.file.Paths.get("C:\\Users\\dzusk\\IdeaProjects\\laba 8\\input.txt"), inputData);

        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new DataProcessors());

        dataManager.loadData("C:\\Users\\dzusk\\IdeaProjects\\laba 8\\input.txt");

        dataManager.processData();

        dataManager.saveData("C:\\Users\\dzusk\\IdeaProjects\\laba 8\\output.txt");
    }
}