package companies.microsoft;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("MUC", "LHR"));
        tickets.add(List.of("JFK", "MUC"));
        tickets.add(List.of("SFO", "SJC"));
        tickets.add(List.of("LHR", "SFO"));

        System.out.println(findItinerary(tickets));

        tickets = new ArrayList<>();
        tickets.add(List.of("JFK", "SFO"));
        tickets.add(List.of("JFK", "ATL"));
        tickets.add(List.of("SFO", "ATL"));
        tickets.add(List.of("ATL", "JFK"));
        tickets.add(List.of("ATL", "SFO"));

        System.out.println(findItinerary(tickets));

        tickets = new ArrayList<>();
        tickets.add(List.of("JFK", "KUL"));
        tickets.add(List.of("JFK", "NRT"));
        tickets.add(List.of("NRT", "JFK"));

        System.out.println(findItinerary(tickets));
    }

    private static List<String> findItinerary(List<List<String>> tickets) {
        final Map<String, PriorityQueue<String>> graph = buildGraph(tickets);

        final List<String> itinerary = new ArrayList<>();

        dfs(graph, "JFK", itinerary);

        itinerary.add("JFK");
        Collections.reverse(itinerary);

        /*final Queue<String> queue = new LinkedList<>();
        queue.add("JFK");//As per question 'JFK' is the starting point

        while (!queue.isEmpty()) {
            final String from = queue.poll();

            itinerary.add(from);

            final PriorityQueue<String> tos = graph.get(from);
            if (tos != null && tos.size() > 0) {
                queue.add(tos.poll());
            }
        }*/

        return itinerary;
    }

    private static void dfs(final Map<String, PriorityQueue<String>> graph, final String source, List<String> itinerary) {
        final PriorityQueue<String> tos = graph.get(source);

        if (tos != null && tos.size() > 0) {
            while (!tos.isEmpty()) {
                final String to = tos.poll();
                dfs(graph, to, itinerary);
                itinerary.add(to);
            }
        }
    }

    private static Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        final Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (final List<String> ticket : tickets) {
            final String from = ticket.get(0);
            final String to = ticket.get(1);

            if (graph.containsKey(from)) {
                graph.get(from).add(to);
            } else {
                final PriorityQueue<String> list = new PriorityQueue<>();
                list.add(to);
                graph.put(from, list);
            }
        }

        return graph;
    }
}
