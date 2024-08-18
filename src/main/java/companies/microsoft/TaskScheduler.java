package companies.microsoft;

import java.util.*;
import java.util.stream.Collectors;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(leastInterval(tasks, 2));
    }

    private static int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> frequency = new HashMap<>();

        for (char ch : tasks) {
            if (frequency.containsKey(ch)) {
                frequency.put(ch, frequency.get(ch) + 1);
            } else {
                frequency.put(ch, 1);
            }
        }

        //Take a max heap(priority queue) to always keep track of max frequency task
        //Also we don't need to keep track of which task, we just need the frequency
        final Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            maxHeap.add(entry.getValue());
        }

        int result = 0;

        while (!maxHeap.isEmpty()) {
            int time = 0;
            //Temp list to store already executed task which can be performed after n unit of time
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    int freq = maxHeap.poll() - 1;
                    if (freq > 0) {
                        temp.add(freq);
                    }
                    time++;
                }
            }

            //Add back to max heap
            for (int freq : temp) {
                maxHeap.add(freq);
            }

            result += maxHeap.isEmpty() ? time : n + 1;
        }

        return result;
    }
}
