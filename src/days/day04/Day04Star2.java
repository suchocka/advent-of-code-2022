package days.day04;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day04Star2 {

    private final String PAIR_SPLIT_MARK = ",";
    private final String SECTION_RANGE_MARK = "-";

    public void run(List<String> lines) {
        int overlaps = 0;
        for (String pair : lines) {
            Set<Integer> firstElfSections = getElfSectionList(pair.split(PAIR_SPLIT_MARK)[0]);
            Set<Integer> secondElfSections = getElfSectionList(pair.split(PAIR_SPLIT_MARK)[1]);
            if (sectionsOverlap(firstElfSections, secondElfSections)) {
                overlaps++;
            }
        }
        System.out.println(overlaps);
    }

    private boolean sectionsOverlap(Set<Integer> firstElfSection, Set<Integer> secondElfSection) {
        return firstElfSection.stream().anyMatch(secondElfSection::contains);
    }

    private Set<Integer> getElfSectionList(String sectionRange) {
        List<Integer> sectionBorders = Arrays.stream(sectionRange.split(SECTION_RANGE_MARK))
                .map(Integer::parseInt)
                .toList();
        return IntStream.rangeClosed(sectionBorders.get(0), sectionBorders.get(1))
                .boxed()
                .collect(Collectors.toSet());
    }
}
