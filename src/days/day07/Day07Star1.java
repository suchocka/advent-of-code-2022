package days.day07;

import java.util.List;
import java.util.function.Predicate;

public class Day07Star1 {

    public void run(List<String> fileLines) {
        Node root = new Parser().parseToFileSystem(fileLines);
        Predicate<Node> predicate = getTotalSizePredicate(100000L);
        List<Node> searchedDirectories = new DFS().findDirectoriesWithGivenCondition(root, predicate);
        Long sumOfTotalSizes = calculateSum(searchedDirectories);
        System.out.println(sumOfTotalSizes);
    }

    private Predicate<Node> getTotalSizePredicate(Long totalSize) {
        return node -> NodeType.DIRECTORY.equals(node.getType()) && node.getSize() <= totalSize;
    }

    private Long calculateSum(List<Node> directories) {
        return directories.stream().mapToLong(Node::getSize).sum();
    }
}
