package algoexpert.graph;

import java.util.ArrayList;
import java.util.List;

//https://www.algoexpert.io/questions/depth-first-search
public class DepthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            dfsRecursively(this, array);

            return array;
        }

        public void dfsRecursively(Node vertex, List<String> array) {
            if (vertex != null) {
                array.add(vertex.name);
            }

            if (vertex == null || vertex.children == null || vertex.children.isEmpty()) {
                return;
            }

            for (Node v : vertex.children) {
                dfsRecursively(v, array);
            }
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        Node root = new Node("A");
        root.addChild("B");
        root.addChild("C");
        root.addChild("D");

        root.children.get(0).addChild("E");
        root.children.get(0).addChild("F");

        root.children.get(2).addChild("G");
        root.children.get(2).addChild("H");

        root.children.get(0).children.get(1).addChild("I");
        root.children.get(0).children.get(1).addChild("J");

        root.children.get(2).children.get(0).addChild("K");

        System.out.println(root.depthFirstSearch(new ArrayList<>()));
    }
}
