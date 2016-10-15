package csula.cs4660.quizes;

import csula.cs4660.quizes.models.State;

import java.util.*;

/**
 * Here is your quiz entry point and your app
 */
public class App {
    public static void main(String[] args) {
        // to get a state, you can simply call `Client.getState with the id`
        State initialState = Client.getState("10a5461773e8fd60940a56d2e9ef7bf4").get();
        System.out.println(initialState);
        // to get an edge between state to its neighbor, you can call stateTransition
        System.out.println(Client.stateTransition(initialState.getId(), initialState.getNeighbors()[0].getId()));

        Queue<State> frontier = new LinkedList<>();
        Set<State> exploredSet = new HashSet<>();
        Map<State, State> parents = new HashMap<>();
        frontier.add(initialState);

        while (!frontier.isEmpty()) {
            State current = frontier.poll();
            exploredSet.add(current);

            // for every possible action
            for (State neighbor: Client.getState(current.getId()).get().getNeighbors()) {
                // state transition
                if (neighbor.getId().equals("e577aa79473673f6158cc73e0e5dc122")) {
                    // construct actions from endTile
                    System.out.println("found solution with depth of " + findDepth(parents, current, initialState));
                }
                if (!exploredSet.contains(neighbor)) {
                    parents.put(neighbor, current);
                    frontier.add(neighbor);
                }
            }
        }

        System.out.println("Not found solution");
    }

    public static int findDepth(Map<State, State> parents, State current, State start) {
        State c = current;
        int depth = 0;

        while (!c.equals(start)) {
            depth ++;
            c = parents.get(c);
        }

        return depth;
    }
}
