package days.day06;

public class Day06Star1 {

    public void run(String input) {
        int firstMarker = new Common().findFirstMarker(input, 4);
        System.out.println(firstMarker);
    }
}
