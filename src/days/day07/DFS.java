package days.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DFS {

    public List<Node> findDirectoriesWithGivenCondition(Node parent, Predicate<Node> predicate) {
        List<Node> result = new ArrayList<>();
        if (predicate.test(parent)) {
            result.add(parent);
        }
        for (Node node : parent.getChildren()) {
            result.addAll(findDirectoriesWithGivenCondition(node, predicate));
        }
        return result;
    }
}
