package days.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonTest {

    @Test
    void findFirstMarker() {
        Common program = new Common();
        assertEquals(7, program.findFirstMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 4));
        assertEquals(5, program.findFirstMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 4));
        assertEquals(6, program.findFirstMarker("nppdvjthqldpwncqszvftbrmjlhg", 4));
        assertEquals(10, program.findFirstMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4));
        assertEquals(11, program.findFirstMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4));
    }
}