import java.util.*;

public class Solution {

    enum MOVE {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

    public static void main(String[] args) {
        // read from System in as example
        Scanner in = new Scanner(System.in);

        // get the size of the two dimension array of tiles
        int size = in.nextInt();

        Tile[][] tiles = new Tile[size][size];

        int startRow = 0;
        int startCol = 0;

        // parse each tile one by one
        for (int i = 0; i < tiles.length; i ++) {
            String str = in.next();
            for (int j = 0; j < tiles[i].length; j ++) {
                tiles[i][j] = new Tile(String.valueOf(str.charAt(j)), i, j);

                if (tiles[i][j].state == Tile.STATE.START) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        BFS(tiles, tiles[startRow][startCol])
            .forEach(System.out::println);
    }

    /**
     * BFS implementation by pseudocode provided
     **/
    public static List<MOVE> BFS(Tile[][] tiles, Tile startTile) {
        List<MOVE> result = new ArrayList<>();
        Map<Tile, Tile> parents = new HashMap<>();
        Tile endTile = new Tile();

        // open set
        Queue<Tile> frontier = new LinkedList<>();
        // closed set
        Collection<Tile> exploredSet = new LinkedList<>();

        exploredSet.add(startTile);
        parents.put(startTile, null);
        frontier.add(startTile);

        while (!frontier.isEmpty()) {
            Tile u = frontier.poll();

            // for all the neighbors (possible next moves)
            for (Tile tile: findPossibleNextMoves(tiles, u.row, u.col)) {
                if (!exploredSet.contains(tile)) {
                    exploredSet.add(tile);
                    parents.put(tile, u);
                    frontier.add(tile);
                }

                if (tile.state == Tile.STATE.END) {
                    endTile = tile;
                }
            }
        }

        // build the list of moves by recursively calling parent
        while (endTile.state != Tile.STATE.START) {
            // construct move from endTile to parent
            if (parents.get(endTile) == null) {
                break;
            }
            if (endTile.row > parents.get(endTile).row) {
                result.add(MOVE.DOWN);
            } else if (endTile.row < parents.get(endTile).row) {
                result.add(MOVE.UP);
            } else if (endTile.col < parents.get(endTile).col) {
                result.add(MOVE.LEFT);
            } else {
                result.add(MOVE.RIGHT);
            }
            endTile = parents.get(endTile);
        }

        Collections.reverse(result);

        return result;
    }

    public static List<Tile> findPossibleNextMoves(
        Tile[][] tiles,
        int row,
        int col
    ) {
        List<Tile> result = new ArrayList<>();
        for (MOVE move: MOVE.values()) {
            switch (move) {
                case UP:
                    if (row - 1 >= 0) {
                        result.add(tiles[row-1][col]);
                    }
                    break;
                case LEFT:
                    if (col - 1 >= 0) {
                        result.add(tiles[row][col-1]);
                    }
                    break;
                case DOWN:
                    if (row + 1 < tiles.length) {
                        result.add(tiles[row+1][col]);
                    }
                    break;
                case RIGHT:
                    if (col + 1 < tiles[row].length) {
                        result.add(tiles[row][col+1]);
                    }
                    break;
            }
        }

        return result;
    }

    static class Tile {
        enum STATE {
            EMPTY("-"),
            START("m"),
            END("p");

            private String character;

            STATE(String character) {
                this.character = character;
            }

            public String getCharacter() {
                return this.character;
            }

            public static STATE of(String character) {
                for (STATE t : values()) {
                    if (t.character.equals(character)) {
                        return t;
                    }
                }
                throw new NoSuchElementException();
            }
        }

        public final STATE state;
        public final int row;
        public final int col;

        // dummy constructor
        public Tile() {
            this.state = STATE.EMPTY;
            this.row = 0;
            this.col = 0;
        }
        public Tile(String str, int row, int col) {
            this.state = STATE.of(str);
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "" + this.state + "@" + this.row + ":" + this.col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tile)) return false;

            Tile tile = (Tile) o;

            return row == tile.row && col == tile.col && state == tile.state;
        }
    }
}
