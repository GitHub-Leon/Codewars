package Codewars;

import java.util.ArrayList;

public class LoopInspector {
    public int loopSize(Node node) {
        ArrayList<Node> nodeList = new ArrayList<Node>();

        while (!nodeList.contains(node)) {
            nodeList.add(node);
            node = node.getNext();
        }
        Node start = node;

        int count = 1;
        Node currentNode = start.getNext();
        while (currentNode != start) {
            count++;
            currentNode = currentNode.getNext();
        }

        return count;
    }
}