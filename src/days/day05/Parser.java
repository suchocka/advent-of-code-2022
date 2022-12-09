package days.day05;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final Map<Integer, Stack<Crate>> stacksMap;
    private final List<Move> moves;

    public Parser(List<String> lines) {
        int emptyLineIndex = lines.indexOf("");
        stacksMap = mapLinesIntoStacksMap(lines.subList(0, emptyLineIndex - 1), lines.get(emptyLineIndex - 1));
        moves = mapLinesIntoMoves(lines.subList(emptyLineIndex + 1, lines.size()));
    }

    private Map<Integer, Stack<Crate>> mapLinesIntoStacksMap(List<String> lines, String stackNumerationString) {
        Map<Integer, Stack<Crate>> stacksMap = initializeStacksMap(stackNumerationString);
        Pattern pattern = Pattern.compile("[A-Z]");
        for (int i = lines.size(); i-- > 0; ) {
            String line = lines.get(i);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                for (int count = 0; count <= matcher.groupCount(); count++) {
                    String symbol = matcher.group(count);
                    Integer stackIndex = stackNumerationString.charAt(matcher.start(count)) - '0';
                    stacksMap.get(stackIndex).add(new Crate(symbol));
                }
            }
        }
        return stacksMap;
    }

    private Map<Integer, Stack<Crate>> initializeStacksMap(String stackNumerationString) {
        Map<Integer, Stack<Crate>> map = new TreeMap<>();
        List<Integer> stacksNumeration = mapToIntegers(stackNumerationString);
        stacksNumeration.forEach(stackNumber -> map.put(stackNumber, new Stack<>()));
        return map;
    }

    private List<Integer> mapToIntegers(String stackNumerationString) {
        return Arrays.stream(stackNumerationString.split("\\s+")).filter(s -> !s.isBlank()).map(Integer::parseInt).toList();
    }

    private List<Move> mapLinesIntoMoves(List<String> lines) {
        List<Move> moves = new ArrayList<>(lines.size());
        Pattern pattern = Pattern.compile("\\d+");
        for (String line : lines) {
            String[] matches = pattern.matcher(line)
                    .results()
                    .map(MatchResult::group)
                    .toArray(String[]::new);
            Move move = Move.builder()
                    .quantity(matches[0])
                    .sourceStack(matches[1])
                    .targetStack(matches[2])
                    .build();
            moves.add(move);
        }
        return moves;
    }

    public Map<Integer, Stack<Crate>> getStacksMap() {
        return stacksMap;
    }

    public List<Move> getMoves() {
        return moves;
    }
}
