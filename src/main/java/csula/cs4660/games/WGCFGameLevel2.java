package csula.cs4660.games;

import java.util.Scanner;

/**
 * Wolf, goat, cabbage farmer game
 */
public class WGCFGameLevel2 {
    // w, g, c, f, s, p
    private boolean[] WGCFState = {false, false, false, false, false, false};
    private int counter = 0;
    private static final boolean forHuman = true;

    public static void main(String[] args) {
        WGCFGameLevel2 game = new WGCFGameLevel2();
        Scanner in = new Scanner(System.in);
        WGCFGameAgentLevel2 agent = new WGCFGameAgentLevel2();

        while (!game.isGameEnd()) {
            System.out.println(game);
            if (forHuman) {
                game.takeAction(in.next());
            } else {
                game.takeAction(agent.getAction(game.getState()));
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
            (WGCFState[0] == WGCFState[1] && WGCFState[5] != WGCFState[0]) ||
            (WGCFState[1] == WGCFState[2] && WGCFState[5] != WGCFState[1]) ||
            (WGCFState[0] == WGCFState[4] && WGCFState[5] != WGCFState[0]) ||
            (WGCFState[3] == WGCFState[4] && WGCFState[5] != WGCFState[3])
        );
    }

    private boolean isGameEnd() {
        return WGCFState[0] && WGCFState[1] && WGCFState[2] && WGCFState[3] && WGCFState[4] && WGCFState[5];
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
            case "s":
                return 4;
            case "p":
                return 5;
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
            case 4:
                return "s";
            case 5:
                return "p";
            default:
                throw new IllegalArgumentException();
        }
    }

    private void takeAction(String action) {
        boolean containPerson = false;
        for (char c: action.toCharArray()) {
            String a = String.valueOf(c);
            int index = convertActionToIndex(a);
            if (WGCFState[index] != WGCFState[5]) {
                throw new IllegalArgumentException();
            }
            WGCFState[index] = !WGCFState[index];
            containPerson = index == 5;
        }

        if (!containPerson) {
            WGCFState[5] = !WGCFState[5];
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
