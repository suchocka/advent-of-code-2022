package days.day07;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private NodeType type;
    private Long size;
    private Node parent;
    private List<Node> children = new ArrayList<>();

    public Node(String name, NodeType type, Long size, Node parent) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
