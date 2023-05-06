package scaler.graph;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        final UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        final UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        final UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        final UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        final UndirectedGraphNode node5 = new UndirectedGraphNode(5);
        final UndirectedGraphNode node6 = new UndirectedGraphNode(6);

        node1.neighbors.add(node3);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node3.neighbors.add(node1);

        node2.neighbors.add(node1);

        node4.neighbors.add(node1);
        node4.neighbors.add(node5);
        node4.neighbors.add(node6);

        node5.neighbors.add(node4);

        node6.neighbors.add(node4);

        final UndirectedGraphNode cloned = cloneGraph(node1);

    }

    public static UndirectedGraphNode usingRecusion(UndirectedGraphNode node) {
        final Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        final UndirectedGraphNode clone = cloneRecursively(map, node);

        return clone;
    }

    public static UndirectedGraphNode cloneRecursively(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        final UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);

        for (final UndirectedGraphNode neighbour: node.neighbors) {
            clone.neighbors.add(cloneRecursively(map, neighbour));
        }

        return clone;
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        final Map<Integer, UndirectedGraphNode> visited = new HashMap<>();
        final Map<Integer, UndirectedGraphNode> visitedCopy = new HashMap<>();

        final Queue<UndirectedGraphNode> queue = new LinkedList<>();
        final Queue<UndirectedGraphNode> copyQueue = new LinkedList<>();

        queue.add(node);
        visited.put(node.label, node);

        final UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        copyQueue.add(copy);
        visitedCopy.put(node.label, copy);

        while (!queue.isEmpty()) {
            final UndirectedGraphNode vertex = queue.poll();
            final UndirectedGraphNode copyVertex = copyQueue.poll();

            final List<UndirectedGraphNode> neighbours = vertex.neighbors;
            final List<UndirectedGraphNode> neighboursCopy = new ArrayList<>();
            for (final UndirectedGraphNode neighbour : neighbours) {
                //Check for visited nodes
                if (visited.containsKey(neighbour.label)) {
                    neighboursCopy.add(visitedCopy.get(neighbour.label));
                } else {
                    queue.add(neighbour);
                    visited.put(neighbour.label, neighbour);

                    final UndirectedGraphNode copyNeighbour = new UndirectedGraphNode(neighbour.label);
                    neighboursCopy.add(copyNeighbour);

                    copyQueue.add(copyNeighbour);
                    visitedCopy.put(neighbour.label, copyNeighbour);
                }
            }

            copyVertex.neighbors = neighboursCopy;
        }

        return copy;
    }

    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }
}
