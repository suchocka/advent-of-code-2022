package days.day07;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Day07Star2 {

    public void run(List<String> fileLines) {
        Node root = new Parser().parseToFileSystem(fileLines);
        long unusedSpaceNeeded = 30000000L - (70000000L - root.getSize());
        if (unusedSpaceNeeded < 0) {
            throw new RuntimeException("You already have needed space");
        }
        Predicate<Node> predicate = getMinimalSizePredicate(unusedSpaceNeeded);
        List<Node> searchedDirectories = new DFS().findDirectoriesWithGivenCondition(root, predicate);
        Node directoryToDelete = findSmallest(searchedDirectories);
        System.out.println(directoryToDelete.getSize());
    }

    private Node findSmallest(List<Node> searchedDirectories) {
        return Collections.min(searchedDirectories, Comparator.comparingLong(Node::getSize));
    }

    private Predicate<Node> getMinimalSizePredicate(Long unusedSpaceNeeded) {
        return node -> NodeType.DIRECTORY.equals(node.getType()) && node.getSize() >= unusedSpaceNeeded;
    }
}
