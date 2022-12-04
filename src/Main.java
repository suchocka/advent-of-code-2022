import days.day01.Day01Star1;
import days.day01.Day01Star2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> fileLines = getFileLines("src/days/day01/input.txt");
        new Day01Star2().run(fileLines);
    }

    private static List<String> getFileLines(String fileName) throws IOException {
        List<String> fileLines;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            fileLines = stream.toList();
        }
        return fileLines;
    }
}