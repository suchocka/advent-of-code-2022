package days.day01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day01Star2 {

    public void run(List<String> lines) {
        int elfCalories = 0;
        List<Integer> sumOfElfCaloriesList = new ArrayList<>();
        for (String line : lines) {
            if ("".equals(line)) {
                sumOfElfCaloriesList.add(elfCalories);
                elfCalories = 0;
                continue;
            }
            elfCalories += Integer.parseInt(line);
        }
        sumOfElfCaloriesList.add(elfCalories);
        int result = sumOfElfCaloriesList.stream().sorted(Comparator.reverseOrder()).limit(3).mapToInt(i -> i).sum();
        System.out.println(result);
    }
}
