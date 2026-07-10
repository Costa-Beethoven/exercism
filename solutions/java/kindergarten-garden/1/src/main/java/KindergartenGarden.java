import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KindergartenGarden {

    String garden;

    KindergartenGarden(String garden) {
        this.garden = garden;
    }

    List<Plant> getPlantsOfStudent(String student) {

        List<Plant> result = new ArrayList<>();

        String garden1 = garden.substring(0, (garden.length() - 1)/2);
        String garden2 = garden.substring(((garden.length() - 1)/2) + 1);

        result.add(Plant.getPlant(garden1.charAt(studentsMap().get(student)*2 - 2)));
        result.add(Plant.getPlant(garden1.charAt(studentsMap().get(student)*2 - 1)));

        result.add(Plant.getPlant(garden2.charAt(studentsMap().get(student)*2 - 2)));
        result.add(Plant.getPlant(garden2.charAt(studentsMap().get(student)*2 - 1)));

        return result;
    }

    private static Map<String, Integer> studentsMap() {
        Map<String, Integer> studentNames = new HashMap<>();
        studentNames.put("Alice", 1);
        studentNames.put("Bob", 2);
        studentNames.put("Charlie", 3);
        studentNames.put("David", 4);
        studentNames.put("Eve", 5);
        studentNames.put("Fred", 6);
        studentNames.put("Ginny", 7);
        studentNames.put("Harriet", 8);
        studentNames.put("Ileana", 9);
        studentNames.put("Joseph", 10);
        studentNames.put("Kincaid", 11);
        studentNames.put("Larry", 12);
        return studentNames;
    }

}
