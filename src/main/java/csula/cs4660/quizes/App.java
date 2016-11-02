package csula.cs4660.quizes;

import csula.cs4660.quizes.models.State;
import csula.cs4660.quizes.models.DTO;

import java.util.*;

/**
 * Here is your quiz entry point and your app
 */
public class App {
    public enum SEARCH_STRATEGY {
        BFS,
        DIJKSTRA
    }

    public static void main(String[] args) {
        Map<State, Integer> bfsPath = search(
            SEARCH_STRATEGY.BFS,
            "10a5461773e8fd60940a56d2e9ef7bf4",
            "e577aa79473673f6158cc73e0e5dc122"
        );
        Map<State, Integer> dijkstraPath = search(
            SEARCH_STRATEGY.DIJKSTRA,
            "10a5461773e8fd60940a56d2e9ef7bf4",
            "e577aa79473673f6158cc73e0e5dc122"
        );

        System.out.println("BFS:");
        printPathReverse(bfsPath);
        System.out.println("DijkStra:");
        printPathReverse(dijkstraPath);
    }

    public static void printPathReverse(Map<State, Integer> path) {
        // traverse the map in reverse order by iterator
        ListIterator<Map.Entry<State, Integer>> iterator =
            new ArrayList<>(path.entrySet()).listIterator(path.size());
        while (iterator.hasPrevious()) {
            Map.Entry<State, Integer> entry = iterator.previous();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static Map<State, Integer> search(SEARCH_STRATEGY strategy, String start, String end) {
        State initialState = Client.getState(start).get();
        Map<State, Integer> distances = new HashMap<>();
        Map<State, State> parents = new HashMap<>();
        Set<State> exploredSet = new HashSet<>();
        Queue<State> frontier;
        switch (strategy) {
            case BFS:
                frontier = new LinkedList<>();
                break;
            case DIJKSTRA:
                frontier = new PriorityQueue<>(10, new StateComparator(distances));
                break;
            default:
                frontier = new LinkedList<>();
                break;
        }
        frontier.add(initialState);
        distances.put(initialState, 0);

        while (!frontier.isEmpty()) {
            State current = frontier.poll();
            exploredSet.add(current);

            // state transition
            if (current.getId().equals(end)) {
                // construct actions from endTile
                System.out.println("Found path");
                return constructPath(parents, distances, current);
            }

            // for every possible action
            for (State neighbor: Client.getState(current.getId()).get().getNeighbors()) {
                if (!exploredSet.contains(neighbor)) {
                    Optional<DTO> transition = Client.stateTransition(current.getId(), neighbor.getId());
                    distances.put(
                        neighbor,
                        distances.getOrDefault(current, 0) + transition.get().getEvent().getEffect()
                    );
                    parents.put(neighbor, current);
                    frontier.add(neighbor);
                }
            }
        }

        return new HashMap<>();
    }

    public static Map<State, Integer> constructPath(Map<State, State> parents, Map<State, Integer> distances, State current) {
        State c = current;
        Map<State, Integer> result = new LinkedHashMap<>();

        while (parents.get(c) != null) {
            result.put(c, distances.get(c));
            c = parents.get(c);
        }
        result.put(c, distances.get(c));

        return result;
    }

    public static class StateComparator implements Comparator<State> {
        private final Map<State, Integer> distances;
        public StateComparator(Map<State, Integer> distances) {
            this.distances = distances;
        }

        @Override
        public int compare(State a, State b) {
            return distances.getOrDefault(b, Integer.MAX_VALUE)
                .compareTo(distances.getOrDefault(a, Integer.MAX_VALUE));
        }
    }
}
