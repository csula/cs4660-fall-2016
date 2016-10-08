package csula.cs4660.games;

import java.util.Scanner;

/**
 * Wolf, goat, cabbage farmer game
 */
public class WGCFGame {
    private boolean[] WGCFState = {false, false, false, false};
    private int counter = 0;
    private static final boolean forHuman = false;

    public static void main(String[] args) {
        WGCFGame game = new WGCFGame();
        Scanner in = new Scanner(System.in);
        WGCFGameAgent agent = new WGCFGameAgent();

        while (!game.isGameEnd()) {
            System.out.println(game);
            if (forHuman) {
                game.takeAction(in.next());
            } else {
                String action = agent.getAction(game.getState());
                System.out.println("got action from agent: " + action);
                game.takeAction(action);
            }
            if (!game.isValidState()) {
                System.out.println("You lose!");
                break;
            }
            game.counter ++;
        }
        if (game.isValidState()) {
            System.out.println(game);
            System.out.println("You win!");
        }
    }

    private boolean[] getState() {
        return WGCFState;
    }

    private boolean isValidState() {
        return !(
            WGCFState[1] == !WGCFState[3] &&
            (
                WGCFState[0] == WGCFState[1] ||
                WGCFState[1] == WGCFState[2]
            )
        );
    }

    private boolean isGameEnd() {
        return WGCFState[0] && WGCFState[1] && WGCFState[2] && WGCFState[3];
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

    private void takeAction(String action) {
        int index = convertActionToIndex(action);
        if (WGCFState[index] != WGCFState[3]) {
            throw new IllegalArgumentException();
        }
        WGCFState[index] = !WGCFState[index];
        if (index != 3) {
            WGCFState[3] = !WGCFState[3];
        }
    }

    private String convertString(boolean[] state) {
        String result = "";
        for (int i = 0; i < WGCFState.length; i ++) {
            if (!WGCFState[i]) {
                result += convertIndexToAction(i);
            }
        }
        result += "\t|\t";
        for (int i = 0; i < WGCFState.length; i ++) {
            if (WGCFState[i]) {
                result += convertIndexToAction(i);
            }
        }


        return result;
    }

    @Override
    public String toString() {
        return "WGCFGame{\n" +
            "\tcounter=" + counter + "\n" +
            "\tWGCFState=" + convertString(WGCFState) + "\n" +
            "}\n";
    }
}
