package days.day07;

import java.util.List;
import java.util.Optional;

public class Parser {

    public Node parseToFileSystem(List<String> lines) {
        FileSystem fileSystem = new FileSystem();
        lines.forEach(line -> {
            if (isCommandLine(line)) {
                parseCommandLine(line, fileSystem);
            } else {
                parseListLine(line, fileSystem);
            }
        });
        return fileSystem.getRoot();
    }

    private void parseCommandLine(String line, FileSystem fileSystem) {
        if (line.startsWith("$ cd")) {
            processChangeDirectoryConstruction(line, fileSystem);
        }
    }

    private void processChangeDirectoryConstruction(String line, FileSystem fileSystem) {
        String[] lineParts = line.split(" ");
        String argument = lineParts[2];
        if ("/".equals(argument)) {
            Node root = new Node("root", NodeType.DIRECTORY, 0L, null);
            fileSystem.setRoot(root);
            fileSystem.setCurrentNode(root);
        } else if ("..".equals(argument)) {
            Node currentNode = fileSystem.getCurrentNode();
            fileSystem.setCurrentNode(currentNode.getParent());
        } else {
            Optional<Node> childNode = findInChildren(NodeType.DIRECTORY, fileSystem.getCurrentNode().getChildren(), argument);
            if (childNode.isPresent()) {
                fileSystem.setCurrentNode(childNode.get());
            } else {
                Node newDirectory = new Node(argument, NodeType.DIRECTORY, 0L, fileSystem.getCurrentNode());
                fileSystem.setCurrentNode(newDirectory);
            }
        }
    }

    private void parseListLine(String line, FileSystem fileSystem) {
        String[] lineParts = line.split(" ");
        String name = lineParts[1];
        Node currentNode = fileSystem.getCurrentNode();
        NodeType nodeType = "dir".equals(lineParts[0]) ? NodeType.DIRECTORY : NodeType.FILE;
        Optional<Node> childNode = findInChildren(nodeType, currentNode.getChildren(), name);
        if (childNode.isEmpty()) {
            createNewNode(lineParts, currentNode, nodeType);
        }
    }

    private void createNewNode(String[] lineParts, Node currentNode, NodeType nodeType) {
        Long size = NodeType.FILE.equals(nodeType) ? Long.parseLong(lineParts[0]) : 0L;
        Node newNode = new Node(lineParts[1], nodeType, size, currentNode);
        currentNode.getChildren().add(newNode);
        if (NodeType.FILE.equals(nodeType)) {
            updateParentSize(currentNode, size);
        }
    }

    private void updateParentSize(Node currentNode, Long size) {
        currentNode.setSize(currentNode.getSize() + size);
        if (currentNode.getParent() != null) {
            updateParentSize(currentNode.getParent(), size);
        }
    }

    private Optional<Node> findInChildren(NodeType nodeType, List<Node> children, String name) {
        return children.stream().filter(node -> nodeType.equals(node.getType()) && name.equals(node.getName())).findFirst();
    }

    private boolean isCommandLine(String line) {
        return line.startsWith("$");
    }
}
