package scaler.heaps;

import java.util.*;

public class NMaxPairCombinations {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        PriorityQueue<HeapNode> maxHeap = new PriorityQueue<>((o1, o2) -> o2.nodeSum - o1.nodeSum);
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();

        A.sort(Comparator.reverseOrder());
        B.sort(Comparator.reverseOrder());

        HashSet<String> usedPairs = new HashSet<>();
        maxHeap.add(new HeapNode(0, 0, A.get(0) + B.get(0)));

        while (result.size() < A.size()) {
            HeapNode currNode = maxHeap.remove();
            String indexPair = currNode.indexA + "#" + currNode.indexB;

            if (!usedPairs.contains(indexPair)) {
                usedPairs.add(indexPair);
                result.add(currNode.nodeSum);
            }

            if (result.size() == A.size()) {
                break;
            }

            int indexA = currNode.indexA + 1;
            int indexB = currNode.indexB + 1;

            if (indexA < n && !usedPairs.contains(indexA + "#" + currNode.indexB)) {
                maxHeap.add(new HeapNode(indexA, currNode.indexB, A.get(indexA) + B.get(currNode.indexB)));
            }

            if (indexB < n && !usedPairs.contains(currNode.indexA + "#" + indexB)) {
                maxHeap.add(new HeapNode(currNode.indexA, indexB, A.get(currNode.indexA) + B.get(indexB)));
            }
        }
        return result;
    }

    static class HeapNode {
        int indexA;
        int indexB;
        int nodeSum;

        HeapNode(int i, int j, int num) {
            this.indexA = i;
            this.indexB = j;
            this.nodeSum = num;
        }
    }
}
