package days.day01;

import java.util.List;

public class Day01Star1 {
    public void run(List<String> lines) {
        int calories = 0;
        int maxCalories = 0;
        for (String line : lines) {
            if ("".equals(line)) {
                if (calories > maxCalories) {
                    maxCalories = calories;
                }
                calories = 0;
                continue;
            }
            calories += Integer.parseInt(line);
        }
        System.out.println("Max = " + maxCalories);
    }
}
