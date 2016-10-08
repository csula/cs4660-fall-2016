package csula.cs4660.games;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Simple game agent for playing games
 */
public class WGCFGameAgent {
    public class State {
        boolean[] data;
        State parent;

        public State(boolean[] data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;

            State state = (State) o;

            return Arrays.equals(data, state.data);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(data);
        }

        @Override
        public String toString() {
            return "State{" +
                "data=" + Arrays.toString(data) +
                '}';
        }
    }

    public String getAction(boolean[] state) {
        List<String> possibleActions = getPossibleActions(state);
        Queue<State> frontier = new LinkedList<>();
        frontier.add(new State(state));

        while (!frontier.isEmpty()) {
            State current = frontier.poll();

            // for every possible action
            for (String possibleAction: getPossibleActions(current.data)) {
                // state transition
                State neighbor = stateTransition(current, possibleAction);
                neighbor.parent = current;
                if (isGoal(neighbor)) {
                    // construct actions from endTile
                    return String.valueOf(constructPath(neighbor).charAt(0));
                }
                frontier.add(neighbor);
            }
        }

        // pick random actions from the possibleActions
        Random rand = new Random();

        return possibleActions.get(rand.nextInt(possibleActions.size()));
    }

    private String constructPath(State neighbor) {
        State current = neighbor;
        String result = "";
        while (!isStart(current)) {
            // construct action back from state to state
            State parent = current.parent;
            if (parent == null) {
                break;
            }
            result += constructAction(current, parent);
            current = parent;
        }
        result = new StringBuilder(result).reverse().toString();

        return result;
    }

    // compare two states and get the action that change the state
    private String constructAction(State current, State parent) {
        String action = "";

        for (int i = 0; i < current.data.length - 1; i ++) {
            if (current.data[i] != parent.data[i]) {
                action = convertIndexToAction(i);
            }
        }
        if (action.equals("")) {
            action = "f";
        }

        return action;
    }

    private boolean isStart(State current) {
        int count = 0;
        for (int i = 0; i < current.data.length; i ++) {
            if (!current.data[i]) {
                count ++;
            }
        }
        return count == current.data.length;
    }


    private List<String> getPossibleActions(boolean[] state) {
        List<String> result = Lists.newArrayList();

        for (int i = 0; i < state.length - 1; i ++) {
            if (state[i] == state[state.length - 1] && isValidMove(state, i)) {
                result.add(convertIndexToAction(i));
            }
        }
        if (isValidMove(state, state.length - 1)) {
            result.add(convertIndexToAction(state.length - 1));
        }

        return result;
    }

    private boolean isValidMove(boolean[] state, int i) {
        boolean[] newState = Arrays.copyOf(state, state.length);
        newState[i] = !newState[i];
        if (i != newState.length - 1) {
            newState[newState.length - 1] =
                !newState[newState.length - 1];
        }

        return !(
            newState[1] == !newState[3] &&
                (
                    newState[0] == newState[1] ||
                        newState[1] == newState[2]
                )
        );
    }

    private boolean isGoal(State state) {
        boolean result = true;
        for (int i = 0; i < state.data.length; i ++) {
            result = result && state.data[i];
        }
        return result;
    }

    // return the new state based on the action
    private State stateTransition(State state, String action) {
        State newState = new State(Arrays.copyOf(state.data, state.data.length));

        int index = convertActionToIndex(action);
        newState.data[index] = !newState.data[index];
        // move farmer with it
        if (index != newState.data.length - 1) {
            newState.data[newState.data.length - 1] =
                !newState.data[newState.data.length - 1];
        }

        return newState;
    }

    private String convertIndexToAction(int i) {
        switch (i) {
            case 0:
                return "w";
            case 1:
                return "g";
            case 2:
                return "c";
            case 3:
                return "f";
            default:
                throw new IllegalArgumentException();
        }
    }

    private int convertActionToIndex(String action) {
        switch (action) {
            case "w":
                return 0;
            case "g":
                return 1;
            case "c":
                return 2;
            case "f":
                return 3;
            default:
                throw new IllegalArgumentException();
        }
    }
}
