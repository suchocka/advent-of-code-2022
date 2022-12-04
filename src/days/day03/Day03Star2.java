package days.day03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day03Star2 {

    public void run(List<String> lines) {
        int sum = 0;
        for (int group = 0; group < lines.size(); group += 3) {
            String firstRucksackInGroup = lines.get(group);
            String secondRucksackInGroup = lines.get(group + 1);
            String thirdRucksackInGroup = lines.get(group + 2);

            String common1To2 = findCommonLetters(firstRucksackInGroup, secondRucksackInGroup);
            String common1To3 = findCommonLetters(firstRucksackInGroup, thirdRucksackInGroup);

            String common = findCommonLetters(common1To2, common1To3);
            sum += getPriority(common.charAt(0));
        }
        System.out.println(sum);
    }

    private String findCommonLetters(String a, String b) {
        Set<Character> common = new HashSet<>();
        for (char c : a.toCharArray()) {
            if (b.contains(String.valueOf(c))) {
                common.add(c);
            }
        }
        return common.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private int getPriority(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 1;
        } else {
            return c - 'A' + 27;
        }
    }
}
