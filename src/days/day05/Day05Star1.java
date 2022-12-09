package days.day05;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Day05Star1 {

    public void run(List<String> lines) {
        Parser parser = new Parser(lines);
        Map<Integer, Stack<Crate>> stacksMap = parser.getStacksMap();
        for (Move move : parser.getMoves()) {
            for (int i = 0; i < move.getQuantity(); i++) {
                Crate crate = stacksMap.get(move.getSourceStack()).pop();
                stacksMap.get(move.getTargetStack()).push(crate);
            }
        }
        String result = getElfMessage(stacksMap);
        System.out.println(result);
    }

    private String getElfMessage(Map<Integer, Stack<Crate>> stacksMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Stack<Crate>> entry: stacksMap.entrySet()) {
            stringBuilder.append(entry.getValue().peek().getSymbol());
        }
        return stringBuilder.toString();
    }
}
