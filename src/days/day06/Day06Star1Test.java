package days.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Star1Test {

    @Test
    void findFirstMarker() {
        Day06Star1 program = new Day06Star1();
        assertEquals(7, program.findFirstMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
        assertEquals(5, program.findFirstMarker("bvwbjplbgvbhsrlpgdmjqwftvncz"));
        assertEquals(6, program.findFirstMarker("nppdvjthqldpwncqszvftbrmjlhg"));
        assertEquals(10, program.findFirstMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
        assertEquals(11, program.findFirstMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));
    }
}