package days.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day06Star2Test {

    @Test
    void findFirstMarker() {
        Day06Star2 program2 = new Day06Star2();
        assertEquals(19, program2.findFirstMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
        assertEquals(23, program2.findFirstMarker("bvwbjplbgvbhsrlpgdmjqwftvncz"));
        assertEquals(23, program2.findFirstMarker("nppdvjthqldpwncqszvftbrmjlhg"));
        assertEquals(29, program2.findFirstMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
        assertEquals(26, program2.findFirstMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));
    }
}