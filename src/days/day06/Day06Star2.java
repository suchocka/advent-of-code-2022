package days.day06;

import java.util.HashSet;
import java.util.Set;

public class Day06Star2 {

    private static final int NUMBER_OF_DISTINCT_CHARACTERS = 14;

    public void run(String input) {
        int firstMarker = findFirstMarker(input);
        System.out.println(firstMarker);
    }

    public int findFirstMarker(String input) {
        int packetStart = NUMBER_OF_DISTINCT_CHARACTERS - 1;
        for (int i = packetStart; i < input.length(); i++) {
            if (isSubsetUnique(input.substring(i - packetStart, i + 1))) {
                return i + 1;
            }
        }
        return -1;
    }

    private boolean isSubsetUnique(String packet) {
        Set<Character> copySet = new HashSet<>();
        for (Character character : packet.toCharArray()) {
            if (!copySet.add(character)) {
                return false;
            }
        }
        return true;
    }
}
