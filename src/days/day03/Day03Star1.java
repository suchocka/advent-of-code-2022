package days.day03;

import java.util.List;

public class Day03Star1 {

    public void run(List<String> lines) {
        int sum = 0;
        for (String rucksack : lines) {
            String firstCompartment = rucksack.substring(0, rucksack.length() / 2);
            String secondCompartment = rucksack.substring(rucksack.length() / 2);
            Character common = findCommonLetter(firstCompartment, secondCompartment);
            if (common != null) {
                sum += getPriority(common);
            }
        }
        System.out.println(sum);
    }

    private Character findCommonLetter(String a, String b) {
        for (char c : a.toCharArray()) {
            if (b.contains(String.valueOf(c))) {
                return c;
            }
        }
        return null;
    }

    private int getPriority(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 1;
        } else {
            return c - 'A' + 27;
        }
    }
}
